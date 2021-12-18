package com.yjq.parser.select.expression;

import lombok.Data;

/**
 * @author Yang Jianqiang
 * @date 2021/12/8
 */
@Data
public class OrExpression {
    AndExpression left;
    Boolean withOr;
    AndExpression right;
}
