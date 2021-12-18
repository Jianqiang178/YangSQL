package com.yjq.parser.select.clause;

import com.yjq.parser.select.expression.Expression;
import lombok.Data;

/**
 * @author Yang Jianqiang
 * @date 2021/12/8
 */
@Data
public class Where {
    Expression expression;
}
