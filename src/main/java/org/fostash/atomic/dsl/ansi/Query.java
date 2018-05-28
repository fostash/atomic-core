package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.ICondition;
import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IJoint;
import org.fostash.atomic.dsl.IQuery;
import org.fostash.atomic.dsl.IQueryDefinition;
import org.fostash.atomic.metamodel.TableMeta;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public class Query implements IQuery, IQueryDefinition {

    /** columns field. */
    private IExpression<?>[] selectList;
    private final Map<String, TableMeta> fromList;
    private ICondition[] conditions;
    private IJoint conditionChain;
//    private final List<ColumnMeta> columns = new LinkedList<>();
//    private final List<Aggregator> aggregators = new LinkedList<>();


    Query() {
        this.selectList = null;
        this.fromList = new LinkedHashMap<>();
        this.conditionChain = null;
    }

    @Override
    public IExpression<?>[] getSelectList() {
        return this.selectList;
    }

    @Override
    public Map<String, TableMeta> getTableList() {
        return this.fromList;
    }

    @Override
    public Map<String, ?> getBindVariables() {
        // TODO
        return null;
    }

    @Override
    public IQuery select(final IExpression<?>... selectList) {
        if (selectList.length > 0) {
            this.selectList = Arrays.copyOf(selectList, selectList.length);
        } else {
            this.selectList = null;
        }

        return this;
    }

    @Override
    public IQuery from(final TableMeta table) {
        this.fromList.put(this.generateUniqueTableAlias(table), table);
        return this;
    }

    @Override
    public IQuery from(final TableMeta table, final String alias) {
        if (this.fromList.containsKey(alias)) {
            throw new IllegalArgumentException(String.format("Alias '%s' has already been used.", alias));
        }

        this.fromList.put(alias, table);
        return this;
    }

    @Override
    public IQuery where(IJoint conditionChain) {
        this.conditionChain = conditionChain;
        return this;
    }

    @Override
    public IQuery where(final ICondition... conditions) {
        this.conditions = conditions;
        return this;
    }

    //    @Override
//    public final IFrom select(final ColumnMeta... c) {
//        if (c.length > 0) {
//            columns.addAll(Arrays.asList(c));
//        } else {
//            columns.add(() -> "*");
//        }
//        return Factory.from(this);
//    }
//
//    @Override
//    public IFrom select(final Aggregator aggregator, final ColumnMeta... columnMetas) {
//        return Factory.from(this);
//    }
//
//    @Override
//    public IFrom select(final List<Aggregator> a, final ColumnMeta... columnMetas) {
//        if (aggregators.size() > 0) {
//            aggregators.addAll(a);
//        }
//        return Factory.from(this);
//    }
//
//    @Override
//    public SqlStructure build() {
//
//        return null;
//    }


    @Override
    public String getRepresentation() {
        // TODO implement
        return null;
    }

    @Override
    public void extractBindVariables(Map<String, ? super Object> vars) {
        // TODO implement
    }

    @Override
    public final String toString() {
        if (this.selectList == null) {
            return "SELECT *";
        }

        final StringBuilder statementPart = new StringBuilder();
        for (final IExpression<?> expr : this.selectList) {
            if (statementPart.length() == 0) {
                statementPart.append("SELECT ");
            } else {
                statementPart.append(", ");
            }

            statementPart.append(expr.getRepresentation());
        }

        return statementPart.toString();
//        return "SELECT "
//                + this.selectList.stream()
//                .map(IExpression::getRepresentation)
//                .collect(Collectors.joining(", "));
    }


    private String generateUniqueTableAlias(final TableMeta table) {
        final String ALIAS_FORMAT = "_alias_%s_%02d_";
        String alias;
        int index = 0;
        do {
            alias = String.format(ALIAS_FORMAT, SQLUtils.getInitials(table.getName()), ++index);
        } while (this.fromList.containsKey(alias));

        return alias;
    }



//    /**
//     * IColumn implementation.
//     */
//    public static final class Column implements IColumn {
//
//        /** name field. */
//        public final String name;
//        /** alias field. */
//        public final String alias;
//        /** function field.
//         * TODO: change to Type defined
//         */
//        public final Aggregator function;
//
//        /**
//         * @param aName column name
//         * @param anAlias column alias
//         * @param aFunction function applied to column
//         */
//        private Column(final String aName, final String anAlias,
//                       final Aggregator aFunction) {
//            this.name = aName;
//            this.alias = anAlias;
//            this.function = aFunction;
//        }
//
//        /**
//         * method for only column name.
//         * @param name column name
//         * @return IColumn interface
//         */
//        public static IColumn column(final String name) {
//            return column(name, null);
//        }
//
//        /**
//         * method for column name and alias.
//         * @param name column name
//         * @param alias column alias
//         * @return IColumn interface
//         */
//        public static IColumn column(final String name, final String alias) {
//            return column(name, alias, null);
//        }
//
//        /**
//         * method for column name, alias and function.
//         * @param name column name
//         * @param alias column alias
//         * @param function column function
//         * @return IColumn interface
//         */
//        public static IColumn column(final String name, final String alias,
//                                     final Aggregator function) {
//            return new Column(name, alias, function);
//        }
//
//        @Override
//        public Aggregator getFunction() {
//            return this.function;
//        }
//
//        @Override
//        public String getName() {
//            return this.name;
//        }
//
//        @Override
//        public String getAlias() {
//            return this.alias;
//        }
//
//        /**
//         * @return function applied to column
//         * @throws SqlBuilderException SqlBuilderException
//         */
//        public String applyFunction() throws SqlBuilderException {
//            return Optional.ofNullable(function)
//                    .orElseThrow(() -> new SqlBuilderException("SqlBuilderException - no function defined for column " + name))
//                    + "(" + name + ")";
//        }
//
//        /**
//         * @return sql string build
//         * @throws SqlBuilderException SqlBuilderException
//         */
//        public String build() throws SqlBuilderException {
//            final StringBuilder builder = new StringBuilder();
//            if (function != null) {
//                builder.append(applyFunction());
//            } else {
//                builder.append(name);
//            }
//            if (alias != null) {
//                builder.append(" ");
//                builder.append(alias);
//            }
//            return builder.toString();
//        }
//
//        @Override
//        public String toString() {
//            return build();
//        }
//    }
}
