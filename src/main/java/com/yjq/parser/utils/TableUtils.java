package com.yjq.parser.utils;

import io.bretty.console.table.Alignment;
import io.bretty.console.table.Table;


import java.util.Arrays;
import java.util.List;


/**
 * @author Yang Jianqiang
 * @date 2021/12/25
 */
public class TableUtils {

    public static void outputTable(List<List<String>> o) {
        String[][] z = new String[o.size()][];
        for (int i = 0; i < o.size(); i++) {
            List<String> temp = o.get(i);
            z[i] = new String[temp.size()];
            for (int j = 0; j < z[i].length; j++) {
                z[i][j] = temp.get(j);
            }
        }
        String[] headers = {"Name", "Last Name", "Team", "Salary"};
        ConsoleTable table = new ConsoleTable(headers);

        table.addRow(new String[] {"Lebron", "James", "LAL", "$33,285,709"});
        table.addRow(new String[] {"Klay", "Thompson", "GSW", "$18,000,000"});
        table.addRow(new String[] {"Kevin", "Durant", "BRK", "$25,000,000"});
        table.addRow(new String[] {"Giannis", "LongLastNameCantBotherToCopy", "MIL", "$23,500,000"});

        table.deleteRow(3);
        table.show();
    }
}
