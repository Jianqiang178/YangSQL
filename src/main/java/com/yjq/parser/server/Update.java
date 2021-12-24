package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
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
        Map<String, Integer> integerMap = table.getHeads().values().stream().collect(Collectors.toMap(Head::getName, Head::getIndex));
        Map<String, String> values = updateStmt.getSetList().getUpdateValues().stream().collect(Collectors.toMap(x -> x.getColumnName().getName(), x -> x.getData().getValue()));
        List<List<GridData>> result = Select.readTable(db, tableName, null);
        for (int i = 0; i < result.size(); i++) {
            int index = i;
            boolean update = true;
            if (updateStmt.getExpression() != null) {
                Map<String, GridData> dataMap = result.get(i).stream().collect(Collectors.toMap(GridData::getColumnName, t -> t));
                updateStmt.getExpression().setColumnValue(dataMap);
                if (!updateStmt.getExpression().getOrExpression().result()) {
                    update = false;
                }
            }
            if (update) {
                values.forEach((key, value) -> {
                    result.get(index).get(integerMap.get(key)).setValue(value);
                });
            }
        }
        reWrite(db, tableName, result);
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
