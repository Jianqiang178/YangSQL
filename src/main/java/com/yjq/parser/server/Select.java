package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Head;
import com.yjq.parser.data.Table;
import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.jjt.ASTColumnName;
import com.yjq.parser.jjt.ASTResultColumn;
import com.yjq.parser.jjt.ASTSelectStmt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
        String tableName = selectStmt.getAstFromList().getFromTables().get(0).getTableName().getName();
        Table table = CreateAndInsert.readTableMeta(db, tableName);
        List<ASTColumnName> columnNames = new ArrayList<>();
        List<String> columns = null;
        if (!selectStmt.getAstResult().isAll()) {
            columnNames = selectStmt.getAstResult().getResultColumns().stream().map(ASTResultColumn::getColumnName).collect(Collectors.toList());
            columns = columnNames.stream().map(ASTColumnName::getName).collect(Collectors.toList());
        } else {
            columns = table.getHeads().values().stream().sorted(Comparator.comparing(Head::getIndex)).map(Head::getName).collect(Collectors.toList());
        }
        for (String column : columns) {
            if (!table.getHeads().containsKey(column)) {
                throw new YangSQLException("'" + column + "'" + "列不存在");
            }
        }
        List<List<GridData>> result = readTable(db, tableName, columns);
        if (selectStmt.getExpression() != null) {
            List<List<GridData>> lists = new ArrayList<>();
            for (List<GridData> gridData : result) {
                Map<String, GridData> dataMap = gridData.stream().collect(Collectors.toMap(GridData::getColumnName, t -> t));
                selectStmt.getExpression().setColumnValue(dataMap);
                if (selectStmt.getExpression().getOrExpression().result()) {
                    lists.add(gridData);
                }
            }
            outputResult(table, columns, lists);
        } else {
            outputResult(table, columns, result);
        }

    }

    /**
     * 将存储文件一行转化为对象
     *
     * @param table
     * @param line
     * @return
     */
    public static List<GridData> translateLine(Table table, String line, List<Integer> index) {
        Map<Integer, Head> headMap = table.getHeads().values().stream().collect(Collectors.toMap(Head::getIndex, t -> t));
        List<GridData> gridDataList = new ArrayList<>();
        String[] strings = line.split("\t");
        assert strings.length == table.getHeads().size();
        for (Integer integer : index) {
            GridData gridData = new GridData();
            gridData.setIndex(integer);
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
        List<List<GridData>> result = new ArrayList<>();
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
     * @param columns
     * @return
     */
    public static List<List<GridData>> readTable(String db, String tableName, List<String> columns) {
        List<List<GridData>> result = new ArrayList<>();
        String dataPath = CreateAndInsert.getDataPath(db, tableName);
        Table table = CreateAndInsert.readTableMeta(db, tableName);
        List<Integer> index = new ArrayList<>();
        if (columns == null || columns.size() == 0) {
            index = table.getHeads().values().stream().sorted(Comparator.comparing(Head::getIndex)).map(Head::getIndex).collect(Collectors.toList());
        } else {
            for (String column : columns) {
                index.add(table.getHeads().get(column).getIndex());
            }
        }
        File file = new File(dataPath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                List<GridData> gridData = translateLine(table, tempStr, index);
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
     * @param table
     * @param columns
     * @param data
     */
    public static void outputResult(Table table, List<String> columns, List<List<GridData>> data) {
        List<Head> heads = table.getHeads().values().stream().filter(x -> columns.contains(x.getName())).sorted(Comparator.comparing(Head::getIndex)).collect(Collectors.toList());
        heads.forEach(head -> System.out.print(head.getName() + "\t"));
        System.out.println();
        for (List<GridData> datum : data) {
            for (GridData gridData : datum) {
                System.out.print(gridData.getValue() + "\t");
            }
            System.out.println();
        }
        System.out.println(data.size() +" rows in set");
    }
}
