/* Generated By:JJTree: Do not edit this line. ASTTableConstraint.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public class ASTTableConstraint extends ASTConstraint{
  public ASTTableConstraint(int id) {
    super(id);
  }

  public ASTTableConstraint(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=2666ad4b95ae51b969f3529b3ad92354 (do not edit this line) */
