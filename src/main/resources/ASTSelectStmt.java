/* Generated By:JJTree: Do not edit this line. ASTSelectStmt.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTSelectStmt extends SimpleNode {
  public ASTSelectStmt(int id) {
    super(id);
  }

  public ASTSelectStmt(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=701a5f2c332dfb89ca4fab2e2000f73a (do not edit this line) */
