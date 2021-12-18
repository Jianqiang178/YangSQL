package com.yjq.parser.select.operator;

/**
 * @author Yang Jianqiang
 * @date 2021/12/3
 */
public abstract class Operator {
    public String operator = null;
    public abstract String calculate();
}
