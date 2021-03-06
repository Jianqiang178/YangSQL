/* Generated By:JJTree: Do not edit this line. ASTNumericLiteral.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ASTNumericLiteral extends SimpleNode {
    private Integer integerValue = null;
    private Double doubleValue = null;

    public ASTNumericLiteral(int id) {
        super(id);
    }

    public ASTNumericLiteral(SQLParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return visitor.visit(this, data);
    }

    /**
     * 获取至类型
     *
     * @return
     */
    public int getType() {
        return integerValue == null ? 2 : 1;
    }

    public String getValue() {
        return integerValue == null ? doubleValue.toString() : integerValue.toString();
    }
}
/* JavaCC - OriginalChecksum=901ceb065e4e64b93f19d15f69954478 (do not edit this line) */
