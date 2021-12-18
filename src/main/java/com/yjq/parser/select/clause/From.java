package com.yjq.parser.select.clause;

import com.yjq.parser.select.FromList;
import lombok.Data;

import java.util.List;

/**
 * @author Yang Jianqiang
 * @date 2021/12/8
 */
@Data
public class From {
    List<FromList> fromListLimit;
}
