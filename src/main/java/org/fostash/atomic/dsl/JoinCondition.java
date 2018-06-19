package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.ansi.Join;
import org.fostash.atomic.dsl.ansi.conditions.BinaryCondition;
import org.fostash.atomic.metamodel.ColumnMeta;
import org.fostash.atomic.metamodel.TableMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JoinCondition extends Join {

    private final List<BinaryCondition> conditions;

    private JoinCondition(TableMeta left, TableMeta right, JoinType type) {
        super(left, right, type);
        this.conditions = new ArrayList<>();
    }

    public static JoinCondition of(final TableMeta left, final TableMeta right, final JoinType type) {
        return new JoinCondition(left, right, type);
    }

    public Join on(final ColumnMeta c1, final ColumnMeta c2) {
        this.conditions.add(new BinaryCondition(c1, c2, "="));
        return this;
    }

    @Override
    public String getRepresentation() {
        return super.getRepresentation()
                .concat(" on ")
                .concat(conditions.stream().map(BinaryCondition::getRepresentation).collect(Collectors.joining(" and ")));
    }
}
