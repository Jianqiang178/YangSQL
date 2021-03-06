/* Generated By:JJTree: Do not edit this line. ASTStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import com.yjq.parser.exceptions.YangSQLException;
import com.yjq.parser.select.SelectStatement;
import com.yjq.parser.server.CreateAndInsert;
import com.yjq.parser.server.Delete;
import com.yjq.parser.server.Select;
import com.yjq.parser.server.Update;
import lombok.Data;

import java.io.IOException;

@Data
public class ASTStatement extends SimpleNode {
    private Integer type;
    private ASTSelectStmt astSelectStmt;
    private ASTInsertStmt insertStmt;
    private ASTCreateStmt createStmt;
    private ASTDeleteStmt deleteStmt;
    private ASTUpdateStmt updateStmt;

    public ASTStatement(int id) {
        super(id);
    }

    public ASTStatement(SQLParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return
                visitor.visit(this, data);
    }

    /**
     * 处理statement语句，有且只有一个子节点，select/create/update/delete
     */
    public void exec() throws YangSQLException, IOException {
        if (children.length == 0) {
            System.out.println("Statement节点无子节点");
            return;
        }
        if (type == 1) {
            Select.dealSelectStmt("YangSQL", astSelectStmt);
        } else if (type == 6) {
            Update.dealUpdateStmt("YangSQL", updateStmt);
        } else if (type == 5) {
            CreateAndInsert.dealInsertData("YangSQL", insertStmt);
        } else if (type == 2) {
            CreateAndInsert.dealCreateStmt("YangSQL", createStmt);
        } else if (type == 4) {
            Delete.dealDeleteStmt("YangSQL", deleteStmt);
        }
    }
}
/* JavaCC - OriginalChecksum=3796e10b29acecf856f40b1d92189c0b (do not edit this line) */
