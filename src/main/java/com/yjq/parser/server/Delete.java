package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.jjt.ASTDeleteStmt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yang Jianqiang
 * @date 2021/12/24
 */
public class Delete {
    public static void dealDeleteStmt(String db, ASTDeleteStmt deleteStmt) throws YangSQLException {
        String tableName = deleteStmt.getTableName().getName();
        Table table = CreateAndInsert.readTableMeta(db, tableName);
        int count = 0;
        Map<String, Integer> integerMap = table.getHeads().values().stream().collect(Collectors.toMap(Head::getName, Head::getIndex));
        List<List<GridData>> result = Select.readTable(db, tableName, deleteStmt.getTableName().getName());
        List<List<GridData>> deleteRows = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            boolean delete = false;
            if (deleteStmt.getExpression() != null) {
                Map<String, GridData> dataMap = result.get(i).stream().collect(Collectors.toMap(GridData::getColumnName, t -> t));
                deleteStmt.getExpression().setColumnValue(dataMap);
                if (deleteStmt.getExpression().getOrExpression().result()) {
                    delete = true;
                }
            }
            if (delete) {
                deleteRows.add(result.get(i));
                count++;
            }
        }
        result.removeAll(deleteRows);
        Update.reWrite(db, tableName, result);
        System.out.println("Delete OK, " + String.valueOf(count) + " row affected");
    }
}
