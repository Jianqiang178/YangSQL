/* Generated By:JavaCC: Do not edit this line. SQLParserVisitor.java Version 7.0.10 */
public interface SQLParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTTableName node, Object data);
  public Object visit(ASTTableAlias node, Object data);
  public Object visit(ASTColumnName node, Object data);
  public Object visit(ASTColumnAlias node, Object data);
  public Object visit(ASTFunctionName node, Object data);
  public Object visit(ASTStringLiteral node, Object data);
  public Object visit(ASTNumericLiteral node, Object data);
  public Object visit(ASTLiteralValue node, Object data);
  public Object visit(ASTOrderTerm node, Object data);
  public Object visit(ASTStart node, Object data);
  public Object visit(ASTExpression node, Object data);
  public Object visit(ASTSelectStmt node, Object data);
  public Object visit(ASTArithmeticOperator node, Object data);
  public Object visit(ASTLogicalOperator node, Object data);
  public Object visit(ASTComparisonOperator node, Object data);
  public Object visit(ASTOperator node, Object data);
  public Object visit(ASTResultColumn node, Object data);
  public Object visit(ASTExpr node, Object data);
  public Object visit(ASTExprr node, Object data);
  public Object visit(ASTFromList node, Object data);
  public Object visit(ASTTuple node, Object data);
  public Object visit(ASTCreT node, Object data);
  public Object visit(ASTColList node, Object data);
  public Object visit(ASTType node, Object data);
  public Object visit(ASTDropT node, Object data);
  public Object visit(ASTDelT node, Object data);
  public Object visit(ASTDelList node, Object data);
  public Object visit(ASTInsT node, Object data);
  public Object visit(ASTInList node, Object data);
  public Object visit(ASTVList node, Object data);
  public Object visit(ASTAttribute node, Object data);
  public Object visit(ASTRelation node, Object data);
  public Object visit(ASTPattern node, Object data);
  public Object visit(ASTIDENTIFIER node, Object data);
}
/* JavaCC - OriginalChecksum=587e9d787b5405f7543fd0e4e32ceb02 (do not edit this line) */
