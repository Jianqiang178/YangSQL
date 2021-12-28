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
        }
        List<String> values = insertStmt.getDataList().getDataList().stream().map(ASTData::getValue).collect(Collectors.toList());
        if (values.size() != columns.size()) {
            throw new YangSQLException("参数不匹配");
        }
        Map<String, String> insertData = generateValueMap(table, columns, insertStmt.getDataList().getDataList());
        checkConstraints(db, table, columns, insertData);
        List<String> insertColumn = table.getHeads().values().stream().sorted(Comparator.comparing(Head::getIndex)).map(Head::getName).collect(Collectors.toList());
        StringBuilder data = new StringBuilder();
        for (String s : insertColumn) {
            if (insertData.containsKey(s)) {
                data.append(insertData.get(s));
            }
            data.append("\t");
        }
        data.append("\n");
        String path = getDataPath(db, table.getName());
        appendContent(path, data.toString(), true);
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

    public static void checkConstraints(String db, Table table, List<String> columns, Map<String, String> insertData) throws YangSQLException {
        StringBuilder data = new StringBuilder();
        // 检查主键
        List<ASTConstraint> constraints = null;
        if (table.getConstraints().get(2).size() > 0) {
            constraints = table.getConstraints().get(2);
            for (ASTConstraint constraint : constraints) {
                List<String> primary = constraint.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
                Map<Integer, String> target = primary.stream().collect(Collectors.toMap(x -> table.getHeads().get(x).getIndex(), insertData::get));
                if (Select.exitDataOneLine(db, table.getName(), target)) {
                    String message = "Duplicate entry '(" + String.join(", ", primary) + ")' for key '" + table.getName() + ".PRIMARY'";
                    throw new YangSQLException(message);
                }
            }
        }
        // 检查唯一约束
        if (table.getConstraints().get(4).size() > 0) {
            constraints = table.getConstraints().get(4);
            for (ASTConstraint constraint : constraints) {
                List<String> unique = constraint.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
                Map<Integer, String> target = unique.stream().collect(Collectors.toMap(x -> table.getHeads().get(x).getIndex(), insertData::get));
                if (Select.exitDataOneLine(db, table.getName(), target)) {
                    String message = "Duplicate entry '(" + String.join(", ", unique) + ")' for key '" + table.getName() + ".UNIQUE'";
                    throw new YangSQLException(message);
                }
            }
        }
        // 检查非空约束
        if (table.getConstraints().get(1).size() > 0) {
            constraints = table.getConstraints().get(1);
            for (ASTConstraint constraint : constraints) {
                List<String> notNull = constraint.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
                for (String s : notNull) {
                    if (!insertData.containsKey(s)) {
                        String message = "Field '" + String.join(", ", notNull) + "' doesn't have a default value for key '" + table.getName() + ".NOT NULL'";
                        throw new YangSQLException(message);
                    }
                }
            }
        }
        // 检查外键
        if (table.getConstraints().get(3).size() > 0) {
            constraints = table.getConstraints().get(3);
            for (ASTConstraint constraint : constraints) {
                List<String> foreignKey = constraint.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
                for (String s : foreignKey) {
                    Map<Integer, String> target = new HashMap<>();
                    target.put(table.getHeads().get(s).getIndex(), insertData.get(s));
                    if (!Select.exitDataOneLine(db, constraint.getTableName().getName(), target)) {
                        throw new YangSQLException(s + "列约束：外键" + constraint.getTableName().getName() + "(" + constraint.getColumnName().getName() + ")不存在" + insertData.get(s));
                    }
                }
            }
        }
    }

    public static Map<Integer, List<ASTConstraint>> parseField(List<Head> heads, ASTColList colList) {
        Map<Integer, List<ASTConstraint>> cons = new HashMap<>();
        for (int i = 0; i <= 4; i++) {
            List<ASTConstraint> constraintList = new ArrayList<>();
            cons.put(i, constraintList);
        }
        for (ASTField field : colList.getFields()) {
            Head head = new Head();
            head.setName(field.getName());
            head.setDataType(field.getDataType());
            head.setIndex(field.getIndex());
            if (field.getConstraints() != null) {
                head.setConstraints(field.getConstraints().getConstraintList());
                for (ASTConstraint constraint : field.getConstraints().getConstraintList()) {
                    ASTColumnName columnName = new ASTColumnName();
                    columnName.setName(field.getName());
                    if (constraint.getType() == 3) {
                        constraint.setForeignKeyColumn(columnName);
                    } else {
                        ASTColumnList columnList = new ASTColumnList();
                        columnList.getColumnNames().add(columnName);
                        constraint.setColumnList(columnList);
                    }
                    cons.get(constraint.getType()).add(constraint);
                }
            }
            heads.add(head);
        }
        return cons;
    }

    public static void parseTableCons(Map<Integer, List<ASTConstraint>> cons, List<Head> heads, ASTConstraints constraints) throws YangSQLException {
        if (constraints == null || constraints.getConstraintList().size() == 0) {
            return;
        }
        for (ASTConstraint constraint : constraints.getConstraintList()) {
            List<String> columns = heads.stream().map(Head::getName).collect(Collectors.toList());
            for (ASTColumnName columnName : constraint.getColumnList().getColumnNames()) {
                if (!columns.contains(columnName.getName())) {
                    throw new YangSQLException("Unknown column: '" + columnName.getName() + "'");
                }
            }
            cons.get(constraint.getType()).add(constraint);
        }
    }

    public static void validForeignKey(String db, Table table, List<Head> heads, List<ASTConstraint> constraintList) throws YangSQLException {
        if (constraintList == null || constraintList.size() == 0) {
            return;
        }
        Map<String, Head> headMap = heads.stream().collect(Collectors.toMap(Head::getName, t -> t));
        for (ASTConstraint constraint : constraintList) {
            Head head = headMap.get(constraint.getForeignKeyColumn().getName());
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
        Map<Integer, List<ASTConstraint>> cons = parseField(heads, createStmt.getColList());
        parseTableCons(cons, heads, createStmt.getColList().getConstraints());
        validForeignKey(db, table, heads, cons.get(3));
        Map<String, Head> headMap = heads.stream().collect(Collectors.toMap(Head::getName, t -> t));
        table.setHeads(headMap);
        table.setConstraints(cons);
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
