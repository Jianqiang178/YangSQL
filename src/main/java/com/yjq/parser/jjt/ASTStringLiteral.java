/* Generated By:JJTree: Do not edit this line. ASTStringLiteral.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.Data;

@Data
public class ASTStringLiteral extends SimpleNode {
    private String value;

    public ASTStringLiteral(int id) {
        super(id);
    }

    public ASTStringLiteral(SQLParser p, int id) {
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
/* JavaCC - OriginalChecksum=c79d44a06004ce35562c0898940f7fab (do not edit this line) */
