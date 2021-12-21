/* Generated By:JJTree: Do not edit this line. ASTSetList.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ASTSetList extends SimpleNode {
  private List<ASTUpdateValue> updateValues = new ArrayList<>();
  public ASTSetList(int id) {
    super(id);
  }

  public ASTSetList(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3015c01097b7e1b6c70a76362011fc6b (do not edit this line) */