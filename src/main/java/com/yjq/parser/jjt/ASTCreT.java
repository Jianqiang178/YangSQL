/* Generated By:JJTree: Do not edit this line. ASTCreT.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public
class ASTCreT extends SimpleNode {
  public ASTCreT(int id) {
    super(id);
  }

  public ASTCreT(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=98cbe88010608e7133ccbaac7e2db1a2 (do not edit this line) */
