/* Generated By:JavaCC: Do not edit this line. SQLParserVisitor.java Version 7.0.10 */
package com.yjq.parser.jjt;

public interface SQLParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTTableName node, Object data);
  public Object visit(ASTTableAlias node, Object data);
  public Object visit(ASTColumnName node, Object data);
  public Object visit(ASTColumnAlias node, Object data);
  public Object visit(ASTFunction node, Object data);
  public Object visit(ASTStringLiteral node, Object data);
  public Object visit(ASTNumericLiteral node, Object data);
  public Object visit(ASTLiteralValue node, Object data);
  public Object visit(ASTStart node, Object data);
  public Object visit(ASTStatement node, Object data);
  public Object visit(ASTSelectStmt node, Object data);
  public Object visit(ASTArithmeticOperator node, Object data);
  public Object visit(ASTLogicalOperator node, Object data);
  public Object visit(ASTComparisonOperator node, Object data);
  public Object visit(ASTAndExpression node, Object data);
  public Object visit(ASTOrExpression node, Object data);
  public Object visit(ASTNullExpression node, Object data);
  public Object visit(ASTLikeExpression node, Object data);
  public Object visit(ASTInExpression node, Object data);
  public Object visit(ASTBetweenExpression node, Object data);
  public Object visit(ASTComparisonExpression node, Object data);
  public Object visit(ASTValue node, Object data);
  public Object visit(ASTExpression node, Object data);
  public Object visit(ASTCondition node, Object data);
  public Object visit(ASTOrderBy node, Object data);
  public Object visit(ASTGroupBy node, Object data);
  public Object visit(ASTLimit node, Object data);
  public Object visit(ASTExist node, Object data);
  public Object visit(ASTOperator node, Object data);
  public Object visit(ASTResult node, Object data);
  public Object visit(ASTResultColumn node, Object data);
  public Object visit(ASTFromList node, Object data);
  public Object visit(ASTFromTable node, Object data);
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
/* JavaCC - OriginalChecksum=40109cd79bc6f5cfab44c7d6e271fc3b (do not edit this line) */
