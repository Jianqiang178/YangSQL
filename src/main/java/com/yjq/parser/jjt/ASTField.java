/* Generated By:JJTree: Do not edit this line. ASTField.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import lombok.Data;

@Data
public class ASTField extends SimpleNode {
  private String dataType;
  private String name;
  public ASTField(int id) {
    super(id);
  }

  public ASTField(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=4107447e3a865db5c4d88abdd8c6d587 (do not edit this line) */