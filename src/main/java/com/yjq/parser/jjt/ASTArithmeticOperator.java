/* Generated By:JJTree: Do not edit this line. ASTArithmeticOperator.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public
class ASTArithmeticOperator extends SimpleNode {
  public ASTArithmeticOperator(int id) {
    super(id);
  }

  public ASTArithmeticOperator(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=56f250dc11d148ad5064716f231b7436 (do not edit this line) */
