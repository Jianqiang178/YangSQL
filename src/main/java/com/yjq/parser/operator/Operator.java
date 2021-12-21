package com.yjq.parser.operator;

import com.yjq.parser.jjt.ASTData;

public interface Operator {
    boolean compare(ASTData left, ASTData right);
}
