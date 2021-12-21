package com.yjq.parser.operator;

import com.yjq.parser.jjt.ASTData;


public class Equal implements Operator {
    @Override
    public boolean compare(ASTData left, ASTData right) {
        if (left.getType() == right.getType()) {
            if (left.getType() == 1) {
                if (left.getNumericLiteral().getType() == 1) {
                    return left.getNumericLiteral().getIntegerValue().equals(right.getNumericLiteral().getIntegerValue());
                } else if (left.getNumericLiteral().getType() == 2) {
                    return left.getNumericLiteral().getDoubleValue().equals(right.getNumericLiteral().getDoubleValue());
                }
            } else if (left.getType() == 2) {
                return left.getStringLiteral().getValue().equals(right.getStringLiteral().getValue());
            }
        } else {
            return false;
        }
        return false;
    }
}
