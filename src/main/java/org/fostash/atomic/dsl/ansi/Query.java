package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IQuery;
import org.fostash.atomic.dsl.IQueryDefinition;
import org.fostash.atomic.exception.SqlBuilderException;
import org.fostash.atomic.metamodel.TableMeta;

import java.util.Map;

public class Query implements IQuery, IQueryDefinition {

    /** columns field. */
    private Select select;
    private From from;
    //private IJoint conditionChain;
//    private final List<ColumnMeta> columns = new LinkedList<>();
//    private final List<Aggregator> aggregators = new LinkedList<>();

    Query() {
        //this.conditionChain = null;
    }

    @Override
    public String getAlias() {
        throw new SqlBuilderException("Invalid call to method getAlias on Query, should use getTableAlias()");
    }

    @Override
    public IQuery select(final IExpression<?>... selectList) {
        if (this.select != null) {
            throw new SqlBuilderException("select already called");
        }
        this.select = new Select(selectList);
        return this;
    }

    @Override
    public IQuery from(final TableMeta from) {
        if (this.from != null) {
            throw new SqlBuilderException("from already called");
        }
        this.from = From.of(from);
        return this;
    }

    @Override
    public IQuery from(final Join join) {
        this.from = join;
        return this;
    }

    /*@Override
    public IQuery where(ICondition condition) {
        this.where = new Where(condition);
        return this;
    }

    @Override
    public IQuery and(final ICondition condition) {
        this.where.and(condition);
        return this;
    }

    @Override
    public IQuery or(final ICondition condition) {
        this.where.addCondition(condition);
        return this;
    }*/

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
        return String.format("%s %s", select.getRepresentation(), from.getRepresentation());
    }

    @Override
    public void extractBindVariables(Map<String, ? super Object> vars) {
        // TODO implement
    }
}
