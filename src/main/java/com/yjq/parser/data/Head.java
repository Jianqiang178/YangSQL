package com.yjq.parser.data;

import com.yjq.parser.jjt.ASTConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Head implements Serializable {
    Integer index;
    String name;
    String dataType;
    List<ASTConstraint> constraints;

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

    public List<Integer> getCons() {
        if (constraints != null && constraints.size() > 0) {
            return constraints.stream().map(ASTConstraint::getType).collect(Collectors.toList());
        } else {
            List<Integer> r = new ArrayList<>();
            r.add(0);
            return r;
        }
    }

    public ASTConstraint getConsByType(Integer type) {
        for (ASTConstraint constraint : constraints) {
            if (constraint.getType().equals(type)) {
                return constraint;
            }
        }
        return null;
    }
}
