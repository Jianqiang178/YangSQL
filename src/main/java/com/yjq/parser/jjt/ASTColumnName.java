/* Generated By:JJTree: Do not edit this line. ASTColumnName.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.yjq.parser.jjt;

import com.yjq.parser.data.GridData;
import com.yjq.parser.exceptions.YangSQLException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Data
@NoArgsConstructor
public class ASTColumnName extends SimpleNode implements Serializable {
    private String name = null;
    private Boolean haveTable = null;
    private String tableName = null;
    private ASTData data = null;

    public ASTColumnName(int id) {
        super(id);
    }

    public ASTColumnName(SQLParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(SQLParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public String getNameWithTable() {
        StringBuilder stringBuilder = new StringBuilder();
        if (tableName != null) {
            stringBuilder.append(tableName);
            stringBuilder.append(".");
        }
        stringBuilder.append(name);
        return stringBuilder.toString();
    }

    /**
     * 设置值
     *
     * @param dataMap
     */
    public void setDataValue(Map<String, GridData> dataMap) throws YangSQLException {
        boolean find = false;
        for (Map.Entry<String, GridData> entry : dataMap.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            if (entry.getKey().equals(getNameWithTable()) || entry.getValue().getColumnName().equals(getNameWithTable())) {
                ASTValue value1 = new ASTValue();
                ASTData data = new ASTData();
                String type = entry.getValue().getDataType();
                if (type.equalsIgnoreCase("int")) {
                    ASTNumericLiteral numericLiteral = new ASTNumericLiteral();
                    numericLiteral.setIntegerValue(Integer.parseInt(entry.getValue().getValue()));
                    data.setNumericLiteral(numericLiteral);
                } else if (type.equalsIgnoreCase("char")) {
                    ASTStringLiteral stringLiteral = new ASTStringLiteral();
                    stringLiteral.setValue(entry.getValue().getValue());
                    data.setStringLiteral(stringLiteral);
                } else if (type.equalsIgnoreCase("double")) {
                    ASTNumericLiteral numericLiteral = new ASTNumericLiteral();
                    numericLiteral.setDoubleValue(Double.parseDouble(entry.getValue().getValue()));
                    data.setNumericLiteral(numericLiteral);
                }
                setData(data);
                find = true;
                break;
            }
        }
        if (!find) {
            // TODO 若未找到数据，说明SQL语句列指定错误
            throw new YangSQLException("Unknown column : " + getNameWithTable());
        }
    }
}
/* JavaCC - OriginalChecksum=4fe8e1a3099840476fbc5e3b72278af6 (do not edit this line) */
