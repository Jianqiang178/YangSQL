/* Generated By:JJTree: Do not edit this line. ASTVList.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public
class ASTVList extends SimpleNode {
  public ASTVList(int id) {
    super(id);
  }

  public ASTVList(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d8509f7232efad7004e18e22fe319bd6 (do not edit this line) */
