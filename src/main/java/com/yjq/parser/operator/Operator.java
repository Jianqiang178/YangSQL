package com.yjq.parser.operator;

import com.yjq.parser.jjt.ASTValue;

public interface Operator {
    boolean compare(ASTValue left, ASTValue right);
}
