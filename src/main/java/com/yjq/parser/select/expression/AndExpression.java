package com.yjq.parser.select.expression;

import com.yjq.parser.select.Condition;

/**
 * @author Yang Jianqiang
 * @date 2021/12/3
 */
public class AndExpression {
    Boolean withNotLeft;
    Boolean withNotRight;
    Condition left;
    Condition right;
    Boolean withAnd;
}
