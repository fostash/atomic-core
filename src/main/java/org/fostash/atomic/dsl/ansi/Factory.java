package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.ICondition;
import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IQuery;
import org.fostash.atomic.dsl.IQueryFactory;
import org.fostash.atomic.dsl.ISqlFunction;
import org.fostash.atomic.dsl.ansi.conditions.BinaryCondition;
import org.fostash.atomic.dsl.ansi.conditions.InExpressions;
import org.fostash.atomic.dsl.ansi.conditions.InSubquery;
import org.fostash.atomic.dsl.ansi.conditions.IsNull;
import org.fostash.atomic.dsl.ansi.expressions.BindVariable;
import org.fostash.atomic.dsl.ansi.expressions.functions.LowerCase;
import org.fostash.atomic.dsl.ansi.expressions.functions.SqlFunction;
import org.fostash.atomic.dsl.ansi.expressions.functions.UpperCase;
import org.fostash.atomic.metamodel.ColumnMeta;

/**
 *
 * Created by Fausto on 10/03/16.
 */
public class Factory implements IQueryFactory {

    // TODO: provide method for column, table, set, ....

//    /**
//     * private constructor.
//     */
//    private Factory() {
//    }
//
//    /**
//     * utility method for select from column.
//     * @param c array of columns
//     * @return IFrom interface
//     */
//    public static IFrom select(final IQuery.IColumn...c) {
//        return new Query().select(c);
//    }
//
//    /**
//     * utility method for from.
//     * @param select IQuery interface
//     * @return From instance
//     */
//    public static IFrom from(final IQuery select) {
//        return new From(select);
//    }
//
//    /**
//     * utility method for join tables.
//     * @param from table to join
//     * @return From instance
//     */
//    /*public static IFrom.IJoin withJoin(final IFrom from) {
//        return new From.Join(from);
//    }*/
//
//    /**
//     * utility method for where structure.
//     * @param from IFrom interface
//     * @return Where instance
//     */
//    public static ICondition where(final IFrom from) {
//        return new Condition(from);
//    }
//
//    /**
//     * utility method for where structure.
//     * @param from IFromJoin interface
//     * @return Where instance
//     */
//    /*public static IWhere where(final IFrom.IJoin from) {
//        return new Where(from);
//    }*/
//
//    /**
//     * utility method for where structure.
//     * @param update IUpdate interface
//     * @return Where instance
//     */
//    public static IWhere where(final IUpdate update) {
//        return new Where(update);
//    }
//
//    /**
//     * utility method for where structure.
//     * @param delete IDelete interface
//     * @return Where instance
//     */
//    public static IWhere where(final Delete delete) {
//        return new Where(delete);
//    }
//
//    /**
//     * utility method for conditions.
//     * @param where IWhere interface
//     * @return Condition instance
//     */
//    public static ICondition condition(final IWhere where) {
//        return new Condition(where);
//    }
//
//    /**
//     * utility method for conditions.
//     * @param joint IJoint interface
//     * @return Condition instance
//     */
//    public static ICondition condition(final IJoint joint) {
//        return new Condition(joint);
//    }
//
//    /**
//     * utility method for joint operator.
//     * @param condition ICondition interface
//     * @return Join instance
//     */
//    public static IJoint joint(final ICondition condition) {
//        return new Join(condition);
//    }
//
//    /**
//     * utility method for joint operator.
//     * @param joint IJoint interface
//     * @return Join instance
//     */
//    public static IJoint joint(final IJoint joint) {
//        return new Join(joint);
//    }
//
//    /**
//     * utility method for update.
//     * @param table IFrom.ITable interface
//     * @return Update instance
//     */
//    public static IUpdate update(final IFrom.ITable table) {
//        return new Update(table);
//    }
//
//    /**
//     * utility method for insert.
//     * @return Insert instance
//     */
//    public static IInsert insert() {
//        return new Insert();
//    }
//
//    /**
//     * utility method for delete.
//     * @param table IFrom.ITable interface
//     * @return Where instance
//     */
//    public static IDelete delete(final IFrom.ITable table) {
//        return new Delete(table);
//    }


    @Override
    public IQuery createQuery() {
        return new Query();
    }

    @Override
    public <T> IExpression<T> bind(final String name, final T value) {
        return new BindVariable<>(name, value);
    }

    @Override
    public ISqlFunction function(final String functionName, final IExpression<?> ... arguments) {
        return new SqlFunction(functionName, arguments);
    }

    @Override
    public ISqlFunction toLowerCase(final ColumnMeta<String> arg) {
        return new LowerCase(arg);
    }

    @Override
    public ISqlFunction toUpperCase(final ColumnMeta<String> arg) {
        return new UpperCase(arg);
    }

    @Override
    public <T> ICondition isNull(final IExpression<T> op) {
        return new IsNull<>(op);
    }

    @Override
    public <T> ICondition isNotNull(final IExpression<T> op) {
        return new IsNull<>(op, true);
    }

    @Override
    public <T> ICondition eq(final IExpression<T> op1, final IExpression<T> op2) {
        return new BinaryCondition(op1, op2, "=");
    }

    @Override
    public <T> ICondition neq(final IExpression<T> op1, final IExpression<T> op2) {
        return new BinaryCondition(op1, op2, "!=");
    }

    @Override
    public <T> ICondition gt(final IExpression<T> op1, final IExpression<T> op2) {
        return new BinaryCondition(op1, op2, ">");
    }

    @Override
    public <T> ICondition lt(final IExpression<T> op1, final IExpression<T> op2) {
        return new BinaryCondition(op1, op2, "<");
    }

    @Override
    public <T> ICondition gte(final IExpression<T> op1, final IExpression<T> op2) {
        return new BinaryCondition(op1, op2, ">=");
    }

    @Override
    public <T> ICondition lte(final IExpression<T> op1, final IExpression<T> op2) {
        return new BinaryCondition(op1, op2, "<=");
    }

    @Override
    public <T> ICondition in(final IExpression<T> expression, final IExpression<T>... expressions) {
        return new InExpressions<>(expression, false, expressions);
    }

    @Override
    public <T> ICondition notIn(final IExpression<T> expression, final IExpression<T>... expressions) {
        return new InExpressions<>(expression, true, expressions);
    }

    @Override
    public <T> ICondition in(final IExpression<T> expression, final IQuery subquery) {
        return new InSubquery(expression, subquery, false);
    }

    @Override
    public <T> ICondition notIn(final IExpression<T> expression, final IQuery subquery) {
        return new InSubquery(expression, subquery, true);
    }
}
