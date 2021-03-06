/* Generated By:JJTree: Do not edit this line. ASTDeleteStmt.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.Data;

@Data
public class ASTDeleteStmt extends SimpleNode {
    private ASTTableName tableName = null;
    private ASTExpression expression = null;

    public ASTDeleteStmt(int id) {
        super(id);
    }

    public ASTDeleteStmt(SQLParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return
                visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=088ef1f3611f783bfed2d8827bf77d61 (do not edit this line) */
