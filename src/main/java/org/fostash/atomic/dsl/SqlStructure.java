package org.fostash.atomic.dsl;

import java.util.Map;

public class SqlStructure {

    private final String sql;
    private final Map<String, Object> params; // TODO: ??? {Some}Meta instead of Object as map value for type check

    private SqlStructure(String sql, Map<String, Object> params) {
        this.sql = sql;
        this.params = params;
    }

    public static SqlStructure of(String sql, Map<String, Object> params) {
        return new SqlStructure(sql, params);
    }

    public String getSql() {
        return sql;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
