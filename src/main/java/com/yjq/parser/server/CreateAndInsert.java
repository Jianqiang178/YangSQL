package com.yjq.parser.server;

import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.jjt.*;
import com.yjq.parser.utils.YmlUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yang Jianqiang
 * @date 2021/12/21
 */
public class CreateAndInsert {
    public static String db_path = null;

    /**
     * 创建存储目录
     */
    public static void initDb() {
        if (db_path == null) {
            Map<Object, Object> config = YmlUtils.readConfig();
            Map<String, Object> sql = (Map<String, Object>) config.get("YangSQL");
            db_path = sql.get("db_path").toString();
        }
        createDic(db_path);
    }

    /**
     * 创建表
     *
     * @param db
     */
    public static void createDbDic(String db) {
        String path = db_path + File.separator + db;
        createDic(db);
    }

    /**
     * 创建新表文件夹
     *
     * @param db
     * @param name
     */
    public static void createTableDic(String db, String name) {
        String path = db_path + File.separator + db + File.separator + name;
        createDic(path);
    }

    /**
     * 创建表
     *
     * @param db
     * @param table
     * @throws IOException
     */
    public static void createTable(String db, Table table) throws IOException {
        String meta_path = getMetaPath(db, table.getName());
        String data_path = getDataPath(db, table.getName());
        String table_path = getTablePath(db, table.getName());
        createDic(table_path);
        createFile(meta_path);
        writeObject(meta_path, table);
        createFile(data_path);
    }

    /**
     * 处理添加语句
     *
     * @param insertStmt
     */
    public static void dealInsertData(String db, ASTInsertStmt insertStmt) throws YangSQLException {
        Table table = readTableMeta(db, insertStmt.getTableName().getName());
        List<String> columns = null;
        if (insertStmt.getColumnList() == null) {
            columns = table.getHeads().values().stream().sorted(Comparator.comparing(Head::getIndex)).map(Head::getName).collect(Collectors.toList());
        } else {
            columns = insertStmt.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
            // 验证不能为空的列
            validPrimaryKeyAndNotNull(table, columns);
        }
        List<String> values = insertStmt.getDataList().getDataList().stream().map(ASTData::getValue).collect(Collectors.toList());
        if (values.size() != columns.size()) {
            throw new YangSQLException("参数不匹配");
        }
        Map<String, String> insertData = generateValueMap(table, columns, insertStmt.getDataList().getDataList());
        String data = generateData(db, table, columns, insertData);
        String path = getDataPath(db, table.getName());
        appendContent(path, data, true);
        System.out.println("Insert OK, 1 row affected");
    }

    /**
     * 是否有主键和not null
     *
     * @param table
     * @param columns
     * @throws YangSQLException
     */
    public static void validPrimaryKeyAndNotNull(Table table, List<String> columns) throws YangSQLException {
        for (Head value : table.getHeads().values()) {
            if (value.getCons().contains(2)) {
                if (!columns.contains(value.getName())) {
                    String message = "Field '" + value.getName() + "' doesn't have a default value";
                    throw new YangSQLException(message);
                }
            } else if (value.getCons().contains(1)) {
                if (!columns.contains(value.getName())) {
                    String message = "Field '" + value.getName() + "' doesn't have a default value";
                    throw new YangSQLException(message);
                }
            }
        }
    }

    /**
     * 验证插入参数
     *
     * @param table
     * @param columns
     * @param dataList
     * @return
     * @throws YangSQLException
     */
    public static Map<String, String> generateValueMap(Table table, List<String> columns, List<ASTData> dataList) throws YangSQLException {
        Map<String, String> insertData = new HashMap<>();
        for (int i = 0; i < columns.size(); i++) {
            if (table.getHeads().get(columns.get(i)) == null) {
                throw new YangSQLException("Unknown column : '" + columns.get(i) + "'");
            }
            if (table.getHeads().get(columns.get(i)).getType() != dataList.get(i).getType()) {
                throw new YangSQLException("Column '" + columns.get(i) + "'" + " requires " + table.getHeads().get(columns.get(i)).getDataType() + " type data");
            }
            insertData.put(columns.get(i), dataList.get(i).getValue());
        }
        return insertData;
    }

    public static String generateData(String db, Table table, List<String> columns, Map<String, String> insertData) throws YangSQLException {
        StringBuilder data = new StringBuilder();
        for (String s : columns) {
            Head head = table.getHeads().get(s);
            List<Integer> types = head.getCons();
            if (insertData.get(s) != null) {
                if (types.contains(3)) {
                    ASTConstraint constraint = head.getConsByType(3);
                    if (!Select.exitDataOneLine(db, constraint.getTableName().getName(), constraint.getColumnName().getName(), insertData.get(s))) {
                        throw new YangSQLException(s + "列约束：外键" + constraint.getTableName().getName() + "(" + constraint.getColumnName().getName() + ")不存在" + insertData.get(s));
                    }
                } else if (types.contains(4) || types.contains(2)) {
                    if (Select.exitDataOneLine(db, table.getName(), s, insertData.get(s))) {
                        String message = "";
                        if (types.contains((2))) {
                            message = "Duplicate entry '" + insertData.get(s).toString() + "' for key '" + table.getName() + ".PRIMARY'";
                        } else {
                            message = "Duplicate entry '" + insertData.get(s).toString() + "' for key '" + table.getName() + "." + s + "'";
                        }
                        throw new YangSQLException(message);
                    }
                }
                data.append(insertData.get(s));
            } else {
                if (types.contains(1) || types.contains(2)) {
                    String message = "Field '" + s + "' doesn't have a default value";
                    throw new YangSQLException(message);
                }
            }
            data.append("\t");
        }
        data.append("\n");
        return data.toString();
    }

    /**
     * 处理见表语句
     *
     * @param db
     * @param createStmt
     * @throws IOException
     */
    public static void dealCreateStmt(String db, ASTCreateStmt createStmt) throws YangSQLException {
        Table table = new Table();
        table.setName(createStmt.getTableName());
        List<Head> heads = new ArrayList<>();
        for (ASTField field : createStmt.getColList().getFields()) {
            Head head = new Head();
            head.setName(field.getName());
            head.setDataType(field.getDataType());
            head.setIndex(field.getIndex());
            if (field.getConstraints() != null) {
                head.setConstraints(field.getConstraints().getConstraintList());
            }
            heads.add(head);
        }
        for (Head head : heads) {
            // 约束是否重复
            List<Integer> integers = head.getCons();
            if (integers.size() != integers.stream().distinct().count()) {
                throw new YangSQLException("Constraints for column '" + head.getName() + "' is repeated");
            }
            // 是否存在外键约束
            if (head.getCons().contains(3)) {
                ASTConstraint constraint = head.getConsByType(3);
                if (constraint.getTableName().getName().equals(table.getName())) {
                    // 外键在本表中
                    boolean exist = false;
                    for (Head head1 : heads) {
                        if (head1.getName().equals(constraint.getColumnName().getName())) {
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        throw new YangSQLException(head.getName() + "列外键创建失败, Unknown table : " + constraint.getTableName().getName());
                    }
                } else if (!new File(getMetaPath(db, constraint.getTableName().getName())).exists()) {
                    throw new YangSQLException(head.getName() + "列外键创建失败, Unknown table : " + constraint.getTableName().getName());
                } else {
                    // 外表查找外键
                    Head head1 = getHead(db, constraint.getTableName().getName(), constraint.getColumnName().getName());
                    if (head1 == null || !head1.getDataType().equals(head.getDataType())) {
                        throw new YangSQLException(head.getName() + "列外键创建失败" + constraint.getTableName().getName() + "(" + constraint.getColumnName().getName() + ")数据类型不一样");
                    }
                }
            }
        }
        Map<String, Head> headMap = heads.stream().collect(Collectors.toMap(Head::getName, t -> t));
        table.setHeads(headMap);
        try {
            createTable(db, table);
        } catch (IOException e) {
            e.printStackTrace();
            throw new YangSQLException("文件读写异常");
        }
        System.out.println("Create OK, 0 row affected");
    }

    /**
     * 读取表信息
     *
     * @param db
     * @param tableName
     * @return
     */
    public static Table readTableMeta(String db, String tableName) {
        String path = getMetaPath(db, tableName);
        Table table = (Table) readObject(path);
        return table;
    }

    /**
     * 创建目录
     *
     * @param path
     */
    public static void createDic(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 表是否存在
     *
     * @param db
     * @param tableName
     * @return
     */
    public static boolean existTable(String db, String tableName) {
        return new File(getTablePath(db, tableName)).exists();
    }

    public static Head getHead(String db, String tableName, String column) {
        Table table = readTableMeta(db, tableName);
        return table.getHeads().get(column);
    }

    /**
     * 创建文件
     *
     * @param path
     * @throws IOException
     */
    public static void createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            file.createNewFile();
        }
    }

    /**
     * 想文件追歼内容
     *
     * @param path
     * @param content
     */
    public static void appendContent(String path, String content, boolean append) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            FileWriter writer = null;
            try {
                // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
                writer = new FileWriter(path, append);
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 向文件写入对象
     *
     * @param path
     * @param obj
     */
    public static void writeObject(String path, Object obj) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            ObjectOutputStream objwrite = null;
            try {
                FileOutputStream out = new FileOutputStream(file);
                objwrite = new ObjectOutputStream(out);
                objwrite.writeObject(obj);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objwrite != null) {
                        objwrite.flush();
                        objwrite.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取对象
     *
     * @param path
     * @return
     */
    public static Object readObject(String path) {
        File file = new File(path);
        Object result = null;
        if (file.exists() && !file.isDirectory()) {
            FileInputStream in = null;
            ObjectInputStream objread = null;
            try {
                in = new FileInputStream(path);
                objread = new ObjectInputStream(in);
                result = objread.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objread != null) {
                        objread.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String getMetaPath(String db, String tableName) {
        return db_path + File.separator + db + File.separator + tableName + File.separator + tableName + ".meta";
    }

    public static String getDataPath(String db, String tableName) {
        return db_path + File.separator + db + File.separator + tableName + File.separator + tableName + ".data";
    }

    public static String getTablePath(String db, String tableName) {
        return db_path + File.separator + db + File.separator + tableName;
    }
}
