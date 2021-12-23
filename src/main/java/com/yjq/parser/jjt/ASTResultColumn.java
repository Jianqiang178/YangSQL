/* Generated By:JJTree: Do not edit this line. ASTResultColumn.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.PhantomReference;
@Data
public class ASTResultColumn extends SimpleNode {
    private String childName;
    private Integer type;
    private ASTTableName tableName;
    private ASTColumnName columnName;
    private ASTFunction function;
    private Boolean haveAlias;
    private String alias;

    public ASTResultColumn(int id) {
        super(id);
    }

    public ASTResultColumn(SQLParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return visitor.visit(this, data);
    }

    /**
     * resultColumn有且仅有一个子节点
     */
//    public void getResultColumn() {
//        if (children.length == 0) {
//            System.out.println("ResultColumn have no children");
//            return;
//        }
//        SimpleNode child = (SimpleNode) children[0];
//        this.childName = child.getName();
//        if (child.getName().equals("ColumnName")) {
//            columnName = (ASTColumnName) child;
//            type = 1;
//        } else if (child.getName().equals("TableName")) {
//            columnName = (ASTColumnName) child;
//            type = 2;
//        } else if (child.getName().equals("Function")) {
//            columnName = (ASTColumnName) child;
//        }
//
//    }
}
/* JavaCC - OriginalChecksum=7f5bab010b7d8e2aa3b06bd5a98d572a (do not edit this line) */
