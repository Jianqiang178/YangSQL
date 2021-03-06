/* Generated By:JJTree: Do not edit this line. ASTCreateStmt.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.Data;

import java.util.List;

@Data
public class ASTCreateStmt extends SimpleNode {
    private String tableName;
    private ASTColList colList;
    private ASTConstraints constraints = null;
    public ASTCreateStmt(int id) {
        super(id);
    }

    public ASTCreateStmt(SQLParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=ab5a8f1811fb171c603bf696298fd4c2 (do not edit this line) */
