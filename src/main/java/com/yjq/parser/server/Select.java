package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.jjt.ASTColumnName;
import com.yjq.parser.jjt.ASTFromTable;
import com.yjq.parser.jjt.ASTResultColumn;
import com.yjq.parser.jjt.ASTSelectStmt;
import com.yjq.parser.utils.ConsoleTable;
import com.yjq.parser.utils.TableUtils;
import io.bretty.console.table.Alignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Select {
    /**
     * 读取表
     *
     * @param db
     * @param tableName
     * @return
     */
    public List<GridData> readTable(String db, String tableName) {
        List<GridData> gridData = new ArrayList<>();
        return gridData;
    }

    /**
     * 处理查询语句
     *
     * @param selectStmt
     */
    public static void dealSelectStmt(String db, ASTSelectStmt selectStmt) throws YangSQLException {
        List<ASTFromTable> fromTables = selectStmt.getAstFromList().getFromTables();
        List<List<GridData>> result = new ArrayList<>();
        // 读取表
        Map<String, Table> tableMap = new HashMap<>();
        Map<String, String> alias = new HashMap<>();
        List<ASTResultColumn> resultColumns = selectStmt.getAstResult().getResultColumns();
        for (ASTFromTable fromTable : fromTables) {
            Table table = CreateAndInsert.readTableMeta(db, fromTable.getTableName().getName());
            tableMap.put(fromTable.getTableName().getName(), table);
            alias.put(fromTable.getAlias(), fromTable.getTableName().getName());
            List<List<GridData>> temp = readTable(db, fromTable.getTableName().getName(), fromTable.getAlias());
            result = cartesianProduct(result, temp);
        }
        // 验证读取的列是否存在
        validResultColumn(resultColumns, alias, tableMap);
//        String tableName = selectStmt.getAstFromList().getFromTables().get(0).getTableName().getName();
//        Map<String, Integer> integerMap = table.getHeads().values().stream().collect(Collectors.toMap(Head::getName, Head::getIndex));
//        List<ASTColumnName> columnNames = new ArrayList<>();
//        List<String> columns = null;
//        if (!selectStmt.getAstResult().isAll()) {
//            columnNames = selectStmt.getAstResult().getResultColumns().stream().map(ASTResultColumn::getColumnName).collect(Collectors.toList());
//            columns = columnNames.stream().map(ASTColumnName::getName).collect(Collectors.toList());
//        } else {
//            columns = table.getHeads().values().stream().sorted(Comparator.comparing(Head::getIndex)).map(Head::getName).collect(Collectors.toList());
//        }
//        for (String column : columns) {
//            if (!table.getHeads().containsKey(column)) {
//                throw new YangSQLException("'" + column + "'" + "列不存在");
//            }
//        }
        if (selectStmt.getExpression() != null) {
            List<List<GridData>> lists = new ArrayList<>();
            for (List<GridData> gridData : result) {
                Map<String, GridData> dataMap = gridData.stream().collect(Collectors.toMap(GridData::getNameWithTable, t -> t));
                selectStmt.getExpression().setColumnValue(dataMap);
                if (selectStmt.getExpression().getOrExpression().result()) {
                    lists.add(gridData);
                }
            }
            result = lists;
//            outputResult(table, columns, lists);
        }
        if (selectStmt.getOrderBy() != null) {
            List<ASTColumnName> c = selectStmt.getOrderBy().getColumnNames();
            selectStmt.getOrderBy().sort(result, c);
        }
        if (selectStmt.getLimit() != null) {
            List<List<GridData>> lists = new ArrayList<>();
            int size = Math.min(selectStmt.getLimit().getLimit(), result.size());
            for (int i = selectStmt.getLimit().getOffset(); i < size; i++) {
                lists.add(result.get(i));
            }
            result = lists;
        }
        outputResult(selectStmt.getAstResult().getResultColumns(), result);
    }

    /**
     * 验证查找列是否存在
     *
     * @param resultColumns
     * @param alias
     * @param tableMap
     * @throws YangSQLException
     */
    public static void validResultColumn(List<ASTResultColumn> resultColumns, Map<String, String> alias, Map<String, Table> tableMap) throws YangSQLException {
        for (ASTResultColumn resultColumn : resultColumns) {
            if (resultColumn.getTableName() != null) {
                if (!alias.containsKey(resultColumn.getTableName().getName())) {
                    throw new YangSQLException("Unknown table:" + resultColumn.getTableName().getName());
                }
            } else {
                if (resultColumn.getColumnName().getTableName() != null) {
                    if (!alias.containsKey(resultColumn.getColumnName().getTableName())) {
                        throw new YangSQLException("Unknown table:" + resultColumn.getTableName().getName());
                    } else {
                        if (!tableMap.get(alias.get(resultColumn.getColumnName().getTableName())).getHeads().containsKey(resultColumn.getColumnName().getName())) {
                            throw new YangSQLException("Unknown column:" + resultColumn.getColumnName().getTableName() + "." + resultColumn.getColumnName().getName());
                        }
                    }
                } else {
                    boolean cons = false;
                    for (Table value : tableMap.values()) {
                        if (value.getHeads().containsKey(resultColumn.getColumnName().getName())) {
                            cons = true;
                            break;
                        }
                    }
                    if (!cons) {
                        throw new YangSQLException("Unknown column:" + resultColumn.getColumnName().getName());
                    }
                }
            }
        }
    }

    /**
     * 将存储文件一行转化为对象
     *
     * @param table
     * @param line
     * @return
     */
    public static List<GridData> translateLine(Table table, String tableAlias, String line, List<Integer> index) {
        Map<Integer, Head> headMap = table.getHeads().values().stream().collect(Collectors.toMap(Head::getIndex, t -> t));
        List<GridData> gridDataList = new ArrayList<>();
        String[] strings = line.split("\t");
        assert strings.length == table.getHeads().size();
        for (Integer integer : index) {
            GridData gridData = new GridData();
            gridData.setIndex(integer);
            gridData.setTableName(table.getName());
            gridData.setTableAlias(tableAlias);
            gridData.setDataType(headMap.get(integer).getDataType());
            gridData.setColumnName(headMap.get(integer).getName());
            gridData.setValue(strings[integer]);
            gridDataList.add(gridData);
        }
        return gridDataList;
    }

    /**
     * 将存储文件一行转化为对象
     *
     * @param table
     * @param line
     * @return
     */
    public static Boolean exitDataOneLine(Table table, String line, Integer index, String target) {
        String[] strings = line.split("\t");
        assert strings.length == table.getHeads().size();
        return strings[index].equals(target);
    }

    /**
     * 某列是否存在某值
     *
     * @param db
     * @param tableName
     * @param name
     * @param target
     * @return
     */
    public static boolean exitDataOneLine(String db, String tableName, String name, String target) {
        String dataPath = CreateAndInsert.getDataPath(db, tableName);
        Table table = CreateAndInsert.readTableMeta(db, tableName);
        int index = table.getHeads().get(name).getIndex();
        File file = new File(dataPath);
        BufferedReader reader = null;
        boolean exist = false;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                exist = exitDataOneLine(table, tempStr, index, target);
                if (exist) {
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return exist;
    }

    /**
     * 按列名读取数据
     *
     * @param db
     * @param tableName
     * @return
     */
    public static List<List<GridData>> readTable(String db, String tableName, String tableAlias) throws YangSQLException {
        List<List<GridData>> result = new ArrayList<>();
        String dataPath = CreateAndInsert.getDataPath(db, tableName);
        if (!new File(dataPath).exists()) {
            throw new YangSQLException("Unknown Table:'" + tableName + "'");
        }
        Table table = CreateAndInsert.readTableMeta(db, tableName);
        List<Integer> index = table.getHeads().values().stream().sorted(Comparator.comparing(Head::getIndex)).map(Head::getIndex).collect(Collectors.toList());
        File file = new File(dataPath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while (true) {
                tempStr = reader.readLine();
                if (tempStr == null || "".equals(tempStr)) {
                    break;
                }
                List<GridData> gridData = translateLine(table, tableAlias, tempStr, index);
                result.add(gridData);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 按行读取文件内容
     *
     * @param fileName
     * @return
     */
    public static List<String> readFileContent(String fileName) {
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                result.add(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 输出select结果
     *
     * @param columns
     * @param data
     */
    public static void outputResult(List<ASTResultColumn> columns, List<List<GridData>> data) {
        Map<String, Integer> integerMap = new HashMap<>();
        if (data.size() > 0) {
            List<GridData> line = data.get(0);
            for (int i = 0; i < line.size(); i++) {
                integerMap.put(line.get(i).getNameWithTable(), i);
                integerMap.put(line.get(i).getColumnName(), i);
            }
            List<String> header = new ArrayList<>();
            if (columns.size() == 0) {
                for (GridData gridData : line) {
//                    System.out.print(gridData.getColumnName() + "\t");
                    header.add(gridData.getColumnName());
                }
            } else {
                Map<String, String> columnNameMap = columns.stream().collect(Collectors.toMap(ASTResultColumn::getNameWithTable, ASTResultColumn::getAlias));
                columns.forEach(head -> {
                    header.add(columnNameMap.get(head.getColumnName().getNameWithTable()));
//                    System.out.print(columnNameMap.get(head.getColumnName().getNameWithTable()) + "\t");
                });
            }
            ConsoleTable table = new ConsoleTable(ConsoleTable.toArray(header));
//            System.out.println();
            for (List<GridData> datum : data) {
                List<String> temp = new ArrayList<>();
                if (columns.size() > 0) {
                    for (ASTResultColumn column : columns) {
//                        System.out.print(datum.get(integerMap.get(column.getColumnName().getNameWithTable())).getValue() + "\t");
                        temp.add(datum.get(integerMap.get(column.getColumnName().getNameWithTable())).getValue());
                    }
                } else {
                    for (GridData gridData : datum) {
//                        System.out.print(gridData.getValue() + "\t");
                        temp.add(gridData.getValue());
                    }
                }
//                System.out.println();
                table.addRow(ConsoleTable.toArray(temp));
            }
            table.show();
        }
        System.out.println(data.size() + " rows in set");
    }

    /**
     * 计算笛卡尔集
     *
     * @param table1
     * @param table2
     * @return
     */
    public static List<List<GridData>> cartesianProduct
    (List<List<GridData>> table1, List<List<GridData>> table2) {
        if (table1.size() == 0) {
            return table2;
        }
        if (table2.size() == 0) {
            return table1;
        }
        List<List<GridData>> result = new ArrayList<>();
        table1.forEach(line -> {
            for (List<GridData> gridData : table2) {
                List<GridData> l = new ArrayList<>(line);
                l.addAll(gridData);
                result.add(l);
            }
        });
        return result;
    }

}
