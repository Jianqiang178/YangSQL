/* Generated By:JJTree: Do not edit this line. ASTConstraints.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
public class ASTConstraints extends SimpleNode {
  private List<ASTConstraint> constraintList = new ArrayList<>();
  public ASTConstraints(int id) {
    super(id);
  }

  public ASTConstraints(SQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SQLParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3d0a6810c5b18b8054d3cc4138af7276 (do not edit this line) */
