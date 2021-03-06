package com.yjq.parser.data;

import com.yjq.parser.jjt.ASTConstraint;
import lombok.Data;
import org.w3c.dom.css.CSSStyleRule;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class Table implements Serializable {
    private String name;
    private Map<String, Head> heads;
    private List<Row> data;
    private Map<Integer, List<ASTConstraint>> constraints;
}
