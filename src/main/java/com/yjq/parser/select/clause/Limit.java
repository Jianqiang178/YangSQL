package com.yjq.parser.select.clause;

/**
 * @author Yang Jianqiang
 * @date 2021/12/2
 */
public class Limit {
    String limit;
    String offset;

    public Limit() {
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
