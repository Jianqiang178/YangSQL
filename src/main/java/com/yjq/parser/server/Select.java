package com.yjq.parser.server;

import com.yjq.parser.data.GridData;
import com.yjq.parser.data.Table;
import com.yjq.parser.jjt.ASTSelectStmt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * @param selectStmt
     */
    public void dealSelectStmt(ASTSelectStmt selectStmt) {

    }

    /**
     * 将存储文件一行转化为对象
     * @param table
     * @param line
     * @return
     */
    public List<GridData> translateLine(Table table, String line) {
        List<GridData> gridDataList = new ArrayList<>();
        String[] strings = line.split("\t");
        assert strings.length == table.getHeads().size();
        int index = 0;
        for (String s : table.getHeads().keySet()) {
            GridData gridData = new GridData();
            gridData.setDataType(table.getHeads().get(s).getDataType());
            gridData.setColumnName(s);
            gridData.setValue(strings[index]);
            index++;
            gridDataList.add(gridData);
        }
        return gridDataList;
    }

    /**
     * 按行读取文件内容
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
}
