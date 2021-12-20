package com.yjq.parser.data;

import java.io.Serializable;
import java.util.List;

public class Table implements Serializable {
    private Head head;
    private List<Row> data;
}
