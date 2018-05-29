package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.IQuery;

import java.util.Map;

public class SubQuery extends Query {

    private String queryAlias;

    @Override
    public void extractBindVariables(Map<String, ? super Object> vars) {

    }

    @Override
    public IQuery as(String alias) {
        this.queryAlias = alias;
        return this;
    }

    @Override
    public String getRepresentation() {
        return null;
    }
}
