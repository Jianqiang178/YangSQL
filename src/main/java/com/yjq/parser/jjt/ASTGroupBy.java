/* Generated By:JJTree: Do not edit this line. ASTGroupBy.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public
class ASTGroupBy extends SimpleNode {
  public ASTGroupBy(int id) {
    super(id);
  }

  public ASTGroupBy(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6e35de69b6649054f51b9bc7c5521003 (do not edit this line) */
