package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.Aggregator;
import org.fostash.atomic.dsl.IFrom;
import org.fostash.atomic.dsl.ISelect;
import org.fostash.atomic.dsl.SqlStructure;
import org.fostash.atomic.exception.SqlBuilderException;
import org.fostash.atomic.metamodel.ColumnMeta;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public class Select implements ISelect {

    /** columns field. */
    private final List<ColumnMeta> columns = new LinkedList<>();
    private final List<Aggregator> aggregators = new LinkedList<>();

    @Override
    public final IFrom select(final ColumnMeta... c) {
        if (c.length > 0) {
            columns.addAll(Arrays.asList(c));
        } else {
            columns.add(() -> "*");
        }
        return Factory.from(this);
    }

    @Override
    public IFrom select(final Aggregator aggregator, final ColumnMeta... columnMetas) {
        return Factory.from(this);
    }

    @Override
    public IFrom select(final List<Aggregator> a, final ColumnMeta... columnMetas) {
        if (aggregators.size() > 0) {
            aggregators.addAll(a);
        }
        return Factory.from(this);
    }

    @Override
    public SqlStructure build() {
        // TODO: implement
        return null;
    }

    @Override
    public final String toString() {
        return "SELECT "
                + columns.stream()
                .map(ColumnMeta::build)
                .collect(Collectors.joining(", "));
    }

    /**
     * IColumn implementation.
     */
    public static final class Column implements IColumn {

        /** name field. */
        public final String name;
        /** alias field. */
        public final String alias;
        /** function field.
         * TODO: change to Type defined
         */
        public final Aggregator function;

        /**
         * @param aName column name
         * @param anAlias column alias
         * @param aFunction function applied to column
         */
        private Column(final String aName, final String anAlias,
                       final Aggregator aFunction) {
            this.name = aName;
            this.alias = anAlias;
            this.function = aFunction;
        }

        /**
         * method for only column name.
         * @param name column name
         * @return IColumn interface
         */
        public static IColumn column(final String name) {
            return column(name, null);
        }

        /**
         * method for column name and alias.
         * @param name column name
         * @param alias column alias
         * @return IColumn interface
         */
        public static IColumn column(final String name, final String alias) {
            return column(name, alias, null);
        }

        /**
         * method for column name, alias and function.
         * @param name column name
         * @param alias column alias
         * @param function column function
         * @return IColumn interface
         */
        public static IColumn column(final String name, final String alias,
                                     final Aggregator function) {
            return new Column(name, alias, function);
        }

        @Override
        public Aggregator getFunction() {
            return this.function;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getAlias() {
            return this.alias;
        }

        /**
         * @return function applied to column
         * @throws SqlBuilderException SqlBuilderException
         */
        public String applyFunction() throws SqlBuilderException {
            return Optional.ofNullable(function)
                    .orElseThrow(() -> new SqlBuilderException("SqlBuilderException - no function defined for column " + name))
                    + "(" + name + ")";
        }

        /**
         * @return sql string build
         * @throws SqlBuilderException SqlBuilderException
         */
        public String build() throws SqlBuilderException {
            final StringBuilder builder = new StringBuilder();
            if (function != null) {
                builder.append(applyFunction());
            } else {
                builder.append(name);
            }
            if (alias != null) {
                builder.append(" ");
                builder.append(alias);
            }
            return builder.toString();
        }

        @Override
        public String toString() {
            return build();
        }
    }
}
