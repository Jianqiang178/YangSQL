/* Generated By:JJTree: Do not edit this line. ASTExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.Data;

@Data
public class ASTExpression extends SimpleNode {
    private ASTOrExpression orExpression = null;
    public ASTExpression(int id) {
        super(id);
    }

    public ASTExpression(SQLParser p, int id) {
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
/* JavaCC - OriginalChecksum=4aafb90f098a9fe1ecd5a984f7d5a953 (do not edit this line) */
