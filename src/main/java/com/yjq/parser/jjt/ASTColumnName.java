/* Generated By:JJTree: Do not edit this line. ASTColumnName.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public
class ASTColumnName extends SimpleNode {
  public ASTColumnName(int id) {
    super(id);
  }

  public ASTColumnName(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=4fe8e1a3099840476fbc5e3b72278af6 (do not edit this line) */
