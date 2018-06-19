package org.fostash.atomic.metamodel;

import org.fostash.atomic.dsl.JoinCondition;
import org.fostash.atomic.dsl.ansi.Join;

import java.util.Optional;

public class TableMeta {

    private final String name;
    private String alias;

    private TableMeta(final String name) {
        this.name = name;
    }

    public static TableMeta of(final String name) {
        return new TableMeta(name);
    }

    public TableMeta as(final String alias) {
        this.alias = alias;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getAlias() {
        return Optional.ofNullable(this.alias).map(a -> String.format(" %s", a)).orElse("");
    }

    public JoinCondition innerJoin(final TableMeta other) {
        return JoinCondition.of(this, other, Join.JoinType.INNER);
    }

    public JoinCondition leftJoin(final TableMeta other) {
        return JoinCondition.of(this, other, Join.JoinType.LEFT);
    }

    public JoinCondition rightJoin(final TableMeta other) {
        return JoinCondition.of(this, other, Join.JoinType.RIGHT);
    }

    public Join crossJoin(final TableMeta other) {
        return Join.of(this, other, Join.JoinType.CROSS);
    }
}
