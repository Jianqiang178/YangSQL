/* Generated By:JJTree: Do not edit this line. ASTComparisonOperator.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTComparisonOperator extends SimpleNode {
  public ASTComparisonOperator(int id) {
    super(id);
  }

  public ASTComparisonOperator(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=9333921f7654b45aa554523ffc486adb (do not edit this line) */
