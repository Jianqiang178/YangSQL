/* Generated By:JJTree: Do not edit this line. ASTInExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import com.yjq.parser.interfaces.Expression;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ASTInExpression extends SimpleNode implements Expression {
    private ASTColumnName columnName = null;
    private List<ASTData> data = new ArrayList<>();
    private boolean not = false;

    public ASTInExpression(int id) {
        super(id);
    }

    public ASTInExpression(SQLParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return visitor.visit(this, data);
    }

    @Override
    public boolean result() {
        boolean res = false;
        for (ASTData datum : data) {
            if (columnName.getData() == null) {
                break;
            }
            if (columnName.getData().getType() == datum.getType() && columnName.getData().getValue().equals(datum.getValue())) {
                res = true;
                break;
            }
        }
        if (not) {
            return !res;
        } else {
            return res;
        }
    }
}
/* JavaCC - OriginalChecksum=8bdc2a6607d34e65b19cedc96a2931b8 (do not edit this line) */
