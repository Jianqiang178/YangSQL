/* Generated By:JJTree: Do not edit this line. ASTOrderTerm.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTOrderTerm extends SimpleNode {
  public ASTOrderTerm(int id) {
    super(id);
  }

  public ASTOrderTerm(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=523c7f52962bb28ceae2b38a868c4d5d (do not edit this line) */
