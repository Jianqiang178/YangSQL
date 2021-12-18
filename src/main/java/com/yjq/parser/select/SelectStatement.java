package com.yjq.parser.select;

import lombok.Data;

import java.util.List;

/**
 * @author Yang Jianqiang
 * @date 2021/12/2
 */
@Data
public class SelectStatement {
    Boolean distinct;
    List<ResultColumn> resultColumns;
    Condition condition;
    Boolean withExist;

}
