package com.yjq.parser.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class GridData implements Serializable {
    private Integer index;
    private String tableName;
    private String columnName;
    private String tableAlias;
    private String dataType;
    private String value;

    public String getNameWithTable() {
        StringBuilder name = new StringBuilder();
        if (tableAlias != null) {
            name.append(tableAlias);
            name.append(".");
        } else if (tableName != null) {
            name.append(tableName);
            name.append(".");
        }
        name.append(columnName);
        return name.toString();
    }

}
