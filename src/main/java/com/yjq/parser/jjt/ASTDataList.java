/* Generated By:JJTree: Do not edit this line. ASTDataList.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import com.yjq.parser.select.clause.Limit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ASTDataList extends SimpleNode {
    private List<ASTData> dataList = new ArrayList<>();

    public ASTDataList(int id) {
        super(id);
    }

    public ASTDataList(SQLParser p, int id) {
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
/* JavaCC - OriginalChecksum=14dabaf6e39f04eff452c643b8f2430b (do not edit this line) */