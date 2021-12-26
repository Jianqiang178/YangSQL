package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.jjt.ASTConstraint;
import com.yjq.parser.jjt.ASTData;
import com.yjq.parser.jjt.ASTUpdateStmt;
import com.yjq.parser.jjt.ASTUpdateValue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
                    validUpdateCons(db, table, column, values);
                    update = true;
                }
            }
            if (update) {
                values.forEach((key, value) -> {
                    result.get(index).get(integerMap.get(key)).setValue(value);
                });
                count++;
            }
        }
        reWrite(db, tableName, result);
        System.out.println("Update OK, " + String.valueOf(count) + " row affected");
    }

    /**
     * 验证更新约束
     * @param db
     * @param table
     * @param columns
     * @param insertData
     * @throws YangSQLException
     */
    public static void validUpdateCons(String db, Table table, List<String> columns, Map<String, String> insertData) throws YangSQLException {
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
            } else {
                if (types.contains(1) || types.contains(2)) {
                    String message = "Field '" + s + "' doesn't have a default value";
                    throw new YangSQLException(message);
                }
            }
        }
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
