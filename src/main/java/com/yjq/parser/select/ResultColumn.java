package com.yjq.parser.select;

/**
 * @author Yang Jianqiang
 * @date 2021/12/2
 */
public class ResultColumn {
    String value;
    Boolean hasAlias;
    String alias;

    public ResultColumn() {
    }

    public ResultColumn(String value, Boolean hasAlias, String alias) {
        this.value = value;
        this.hasAlias = hasAlias;
        this.alias = alias;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getHasAlias() {
        return hasAlias;
    }

    public void setHasAlias(Boolean hasAlias) {
        this.hasAlias = hasAlias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
