package org.fostash.atomic.metamodel;

import org.fostash.atomic.dsl.IExpression;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Optional;

public class ColumnMeta<T> implements IExpression<T> {

    private final String name;
    private final String tableAlias;

    protected String alias;

    private ColumnMeta(final String name) {
        this.name = name;
        this.tableAlias = null;
    }

    private ColumnMeta(final String name, final String tableAlias) {
        this.name = name;
        this.tableAlias = tableAlias + ".";
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String getRepresentation() {
        return String.format(
                "%s%s %s",
                Optional.ofNullable(this.tableAlias).orElse(""),
                this.name,
                this.buildAlias()
        ).trim();
    }

    @SuppressWarnings("unchecked")
    public Class<T> getType() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public ColumnMeta<T> as(final String alias) {
        this.alias = alias;
        return this;
    }

    @Override
    public void extractBindVariables(final Map vars) {
        // No bind variables allowed in this context
    }

    public static <T> ColumnMeta<T> of(final String name) {
        return new ColumnMeta<>(name);
    }

    public static <T> ColumnMeta<T> of(final String name, final String tableAlias) {
        return new ColumnMeta<>(name, tableAlias);
    }
}