package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.jjt.*;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yang Jianqiang
 * @date 2021/12/24
 */
public class Update {
    public static void dealUpdateStmt(String db, ASTUpdateStmt updateStmt) throws YangSQLException {
        String tableName = updateStmt.getTableName().getName();
        Table table = CreateAndInsert.readTableMeta(db, tableName);
        int count = 0;
        Map<String, Integer> integerMap = table.getHeads().values().stream().collect(Collectors.toMap(Head::getName, Head::getIndex));
        List<ASTData> data = updateStmt.getSetList().getUpdateValues().stream().map(ASTUpdateValue::getData).collect(Collectors.toList());
        List<String> column = updateStmt.getSetList().getUpdateValues().stream().map(x -> x.getColumnName().getName()).collect(Collectors.toList());
        Map<String, String> values = CreateAndInsert.generateValueMap(table, column, data);
        List<List<GridData>> result = Select.readTable(db, tableName, null);
        for (int i = 0; i < result.size(); i++) {
            int index = i;
            boolean update = false;
            if (updateStmt.getExpression() != null) {
                Map<String, GridData> dataMap = result.get(i).stream().collect(Collectors.toMap(GridData::getColumnName, t -> t));
                updateStmt.getExpression().setColumnValue(dataMap);
                if (updateStmt.getExpression().getOrExpression().result()) {
                    // 判断外键和唯一约束
                    update = true;
                }
            }
            if (update) {
                values.forEach((key, value) -> {
                    result.get(index).get(integerMap.get(key)).setValue(value);
                });
                validUpdateCons(db, table, result.get(index), values, index);
                count++;
            }
        }
        reWrite(db, tableName, result);
        System.out.println("Update OK, " + String.valueOf(count) + " row affected");
    }

    /**
     * 验证更新约束
     *
     * @param db
     * @param table
     * @throws YangSQLException
     */
    public static void validUpdateCons(String db, Table table, List<GridData> line, Map<String, String> updateData, int index) throws YangSQLException {
        // 检查主键
        List<ASTConstraint> constraints = null;
        if (table.getConstraints().get(2).size() > 0) {
            constraints = table.getConstraints().get(2);
            for (ASTConstraint constraint : constraints) {
                List<String> primary = constraint.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
                boolean pr = true;
                for (String s : primary) {
                    if (updateData.containsKey(s)) {
                        if ("".equals(updateData.get(s))) {
                            String message = "Field '" + String.join(", ", primary) + "' doesn't have a default value for key '" + table.getName() + ".NOT NULL'";
                            throw new YangSQLException(message);
                        }
                    } else {
                        pr = false;
                    }
                }
                if (pr) {
                    Map<Integer, String> target = primary.stream().collect(Collectors.toMap(t -> table.getHeads().get(t).getIndex(), t -> updateData.get(t)));
                    if (Select.exitDataOneLine(db, table.getName(), target, index)) {
                        String message = "Duplicate entry '(" + String.join(", ", primary) + ")' for key '" + table.getName() + ".PRIMARY'";
                        throw new YangSQLException(message);
                    }
                }
            }
        }
        // 检查唯一约束
        if (table.getConstraints().get(4).size() > 0) {
            constraints = table.getConstraints().get(4);
            for (ASTConstraint constraint : constraints) {
                List<String> unique = constraint.getColumnList().getColumnNames().stream().map(ASTColumnName::getName).collect(Collectors.toList());
                Map<Integer, String> target = unique.stream().collect(Collectors.toMap(t -> table.getHeads().get(t).getIndex(), t -> updateData.get(t)));
                if (Select.exitDataOneLine(db, table.getName(), target, index)) {
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
                    if (updateData.containsKey(s) && "".equals(updateData.get(s))) {
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
                String foreignKey = constraint.getForeignKeyColumn().getName();
                Map<Integer, String> target1 = new HashMap<>();
                Table foreignTable = CreateAndInsert.readTableMeta(db, constraint.getTableName().getName());
                if (!updateData.containsKey(foreignKey) || "".equals(updateData.get(foreignKey))) {
                    continue;
                }
                target1.put(foreignTable.getHeads().get(constraint.getColumnName().getName()).getIndex(), updateData.get(foreignKey));
                if (!Select.exitDataOneLine(db, constraint.getTableName().getName(), target1, -1)) {
                    String message = "Cannot add or update a child row: a foreign key constraint fails ( FOREIGN KEY ('" + foreignKey + "')" + "REFERENCES" + foreignTable.getName() + "('" + constraint.getColumnName().getName() + "')";
                    throw new YangSQLException(message);
                }
            }
        }
//        for (String s : columns) {
//            Head head = table.getHeads().get(s);
//            List<Integer> types = head.getCons();
//            if (insertData.get(s) != null) {
//                if (types.contains(3)) {
//                    ASTConstraint constraint = head.getConsByType(3);
//                    if (!Select.exitDataOneLine(db, constraint.getTableName().getName(), constraint.getColumnName().getName(), insertData.get(s))) {
//                        throw new YangSQLException(s + "列约束：外键" + constraint.getTableName().getName() + "(" + constraint.getColumnName().getName() + ")不存在" + insertData.get(s));
//                    }
//                } else if (types.contains(4) || types.contains(2)) {
//                    if (Select.exitDataOneLine(db, table.getName(), s, insertData.get(s))) {
//                        String message = "";
//                        if (types.contains((2))) {
//                            message = "Duplicate entry '" + insertData.get(s).toString() + "' for key '" + table.getName() + ".PRIMARY'";
//                        } else {
//                            message = "Duplicate entry '" + insertData.get(s).toString() + "' for key '" + table.getName() + "." + s + "'";
//                        }
//                        throw new YangSQLException(message);
//                    }
//                }
//            } else {
//                if (types.contains(1) || types.contains(2)) {
//                    String message = "Field '" + s + "' doesn't have a default value";
//                    throw new YangSQLException(message);
//                }
//            }
//        }
    }

    public static void reWrite(String db, String tableName, List<List<GridData>> data) {
        List<String> content = new ArrayList<>();
        for (List<GridData> datum : data) {
            StringBuilder stringBuilder = new StringBuilder();
            for (GridData gridData : datum) {
                stringBuilder.append(gridData.getValue() + "\t");
            }
            stringBuilder.append("\n");
            content.add(stringBuilder.toString());
        }
        String data_path = CreateAndInsert.getDataPath(db, tableName);
        appendContent(data_path, content, false);
    }

    public static void appendContent(String path, List<String> content, boolean append) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            FileWriter writer = null;
            try {
                // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
                writer = new FileWriter(path, append);
                for (String s : content) {
                    writer.write(s);
                }
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
}
