package com.yjq.parser.select;

import lombok.Data;

/**
 * @author Yang Jianqiang
 * @date 2021/12/2
 */
@Data
public class ColumnName {
    String tableName;
    String columnMame;
    String alias;
}
