/* Generated By:JJTree: Do not edit this line. ASTFieldConstraints.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

public class ASTFieldConstraints extends ASTConstraints {
  public ASTFieldConstraints(int id) {
    super(id);
  }

  public ASTFieldConstraints(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=5f88ed0cdb788eef8baa8f3bf3c44b4d (do not edit this line) */
