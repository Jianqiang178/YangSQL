package com.yjq.parser.server;

import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.jjt.ASTCreateStmt;
import com.yjq.parser.jjt.ASTInsertStmt;
import com.yjq.parser.jjt.ASTValue;
import com.yjq.parser.utils.YmlUtils;

import java.io.*;
import java.util.List;
import java.util.Map;
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
        String meta_path = db_path + File.separator + db + File.separator + table.getName() + File.separator + table.getName() + ".meta";
        String data_path = db_path + File.separator + db + File.separator + table.getName() + File.separator + table.getName() + ".data";
        createFile(meta_path);
        writeObject(meta_path, table);
        createFile(data_path);
    }

    /**
     * 处理添加语句
     *
     * @param insertStmt
     */
    public void dealInsertData(ASTInsertStmt insertStmt) {

    }

    /**
     * 处理见表语句
     * @param db
     * @param createStmt
     * @throws IOException
     */
    public void dealCreateStmt(String db, ASTCreateStmt createStmt) throws IOException {
        Table table = new Table();
        table.setName(createStmt.getName());
        List<Head> heads = createStmt.getColList().getFields().stream().map(f -> new Head(f.getName(), f.getDataType())).collect(Collectors.toList());
        Map<String, Head> headMap = heads.stream().collect(Collectors.toMap(Head::getName, t -> t));
        table.setHeads(headMap);
        createTable(db, table);
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
    public static void appendContent(String path, String content) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            FileWriter writer = null;
            try {
                // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
                writer = new FileWriter(path, true);
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
    public Object readObject(String path) {
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
}
