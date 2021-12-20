package com.yjq.parser.operator;

import com.yjq.parser.jjt.ASTValue;

public class LessThan implements Operator {
    @Override
    public boolean compare(ASTValue left, ASTValue right) {
        if (left.getType() == right.getType()) {
            if (left.getType() == 1) {
                if (left.getNumericLiteral().getType() == 1) {
                    return left.getNumericLiteral().getIntegerValue() < right.getNumericLiteral().getIntegerValue();
                } else if (left.getNumericLiteral().getType() == 2) {
                    return left.getNumericLiteral().getDoubleValue() < right.getNumericLiteral().getDoubleValue();
                }
            } else if (left.getType() == 2) {
                return left.getStringLiteral().getValue().compareTo(right.getStringLiteral().getValue()) < 0;
            }
        } else {
            return false;
        }
        return false;
    }
}
