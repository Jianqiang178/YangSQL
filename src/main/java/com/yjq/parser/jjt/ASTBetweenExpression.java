/* Generated By:JJTree: Do not edit this line. ASTBetweenExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import com.yjq.parser.interfaces.Expression;
import com.yjq.parser.operator.LessThan;
import com.yjq.parser.operator.LessThanOrEqualTo;
import lombok.Data;

@Data
public class ASTBetweenExpression extends SimpleNode implements Expression {
    private ASTColumnName columnName = null;
    private ASTData first = null;
    private ASTData second = null;
    private boolean not = false;

    public ASTBetweenExpression(int id) {
        super(id);
    }

    public ASTBetweenExpression(SQLParser p, int id) {
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
        if (columnName.getData() != null) {
            res = new LessThanOrEqualTo().compare(first, columnName.getData()) && new LessThan().compare(columnName.getData(), second);
        }
        if (not) {
            return !res;
        } else {
            return res;
        }
    }
}
/* JavaCC - OriginalChecksum=634697302918475bf324d4783f3d5f82 (do not edit this line) */
