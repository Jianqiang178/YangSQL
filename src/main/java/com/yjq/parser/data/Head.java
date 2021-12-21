package com.yjq.parser.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Head implements Serializable {
    String name;
    String dataType;

    public int getType() {
        if (dataType.equalsIgnoreCase("int")) {
            return 1;
        } else if (dataType.equalsIgnoreCase("char")) {
            return 3;
        } else if (dataType.equalsIgnoreCase("double")) {
            return 2;
        } else if (dataType.equalsIgnoreCase("date")) {
            return 4;
        } else {
            return -1;
        }
    }
}
