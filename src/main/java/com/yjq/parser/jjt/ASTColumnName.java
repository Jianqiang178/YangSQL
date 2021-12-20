/* Generated By:JJTree: Do not edit this line. ASTColumnName.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import com.yjq.parser.data.GridData;
import com.yjq.parser.exceptions.YangSQLException;
import lombok.Data;

import java.util.Map;

@Data
public class ASTColumnName extends SimpleNode {
    private String name = null;
    private Boolean haveTable = null;
    private String tableName = null;
    private ASTValue value = null;

    public ASTColumnName(int id) {
        super(id);
    }

    public ASTColumnName(SQLParser p, int id) {
        super(p, id);
    }

    public ASTValue getValue() {
        if (value == null) {
            // FIXME 必须保证tableName可以替换，否则返回列名
            value = new ASTValue();
            ASTStringLiteral stringLiteral = new ASTStringLiteral();
            stringLiteral.setValue(name);
            value.setStringLiteral(stringLiteral);
            return value;
        } else if (value.getType() == 3) {
            return value.getColumnName().getValue();
        } else {
            return value;
        }
    }

    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {

        return visitor.visit(this, data);
    }

    /**
     * 设置值
     *
     * @param dataMap
     */
    public void setDataValue(Map<String, GridData> dataMap) throws YangSQLException {
        boolean find = false;
        for (Map.Entry<String, GridData> entry : dataMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            if (entry.getKey().equals(name)) {
                ASTValue value1 = new ASTValue();
                String type = entry.getValue().getDataType();
                if (type.equalsIgnoreCase("integer")) {
                    ASTNumericLiteral numericLiteral = new ASTNumericLiteral();
                    numericLiteral.setIntegerValue(Integer.parseInt(entry.getValue().getValue()));
                    value1.setNumericLiteral(numericLiteral);
                } else if (type.equalsIgnoreCase("varchar")) {
                    ASTStringLiteral stringLiteral = new ASTStringLiteral();
                    stringLiteral.setValue(entry.getValue().getValue());
                    value1.setStringLiteral(stringLiteral);
                } else if (type.equalsIgnoreCase("double")) {
                    ASTNumericLiteral numericLiteral = new ASTNumericLiteral();
                    numericLiteral.setDoubleValue(Double.parseDouble(entry.getValue().getValue()));
                    value1.setNumericLiteral(numericLiteral);
                }
                find = true;
                break;
            }
        }
        if(!find){
            // TODO 若未找到数据，说明SQL语句错误
            throw new YangSQLException("条件错误");
        }
    }
}
/* JavaCC - OriginalChecksum=4fe8e1a3099840476fbc5e3b72278af6 (do not edit this line) */
