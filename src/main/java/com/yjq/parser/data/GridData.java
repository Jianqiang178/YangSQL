package com.yjq.parser.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class GridData implements Serializable {
    private String columnName;
    private String dataType;
    private String value;
}
