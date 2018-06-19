package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.metamodel.ColumnMeta;

@Deprecated
public class Condition<L, R> /*implements ICondition<L, R>*/ {

    private ColumnMeta<L> left;
    private R[] right;
    //private Operation operator;

//    private ICondition setValue(final ColumnMeta<L> f, final Operation operation, final R... v) {
//        this.left = f;
//        this.right = v;
//        this.operator = operation;
//        return this;
//    }
//
//    @Override
//    public final ICondition eq(final ColumnMeta<L> op1, final R op2) {
//        return new BinaryCondition(op1, op2, "=");
//    }
//
//    @Override
//    public final ICondition notEq(final ColumnMeta<L> f, final R v) {
//        return this.setValue(f, Operation.NOT_EQ, v);
//    }
//
//    @Override
//    public final ICondition gt(final ColumnMeta<L> f, final R v) {
//        return this.setValue(f, Operation.GT, v);
//    }
//
//    @Override
//    public final ICondition lt(final ColumnMeta<L> f, final R v) {
//        return this.setValue(f, Operation.LT, v);
//    }
//
//    @Override
//    public final ICondition ge(final ColumnMeta<L> f, final R v) {
//        return this.setValue(f, Operation.GE, v);
//    }
//
//    @Override
//    public final ICondition le(final ColumnMeta<L> f, final R v) {
//        return this.setValue(f, Operation.LE, v);
//    }
//
//    @Override
//    public final ICondition in(final ColumnMeta<L> f, final R...v) {
//        return this.setValue(f, Operation.IN, v);
//    }
//
//    @Override
//    public final ICondition notIn(final ColumnMeta<L> f, final R[] v) {
//        return this.setValue(f, Operation.NOT_IN, v);
//    }
//
//    @Override
//    public final ICondition exists(final R select) {
//        return this.setValue(null, Operation.EXISTS, select);
//    }
//
//    @Override
//    public final ICondition notExists(final R select) {
//        return this.setValue(null, Operation.NOT_EXISTS, select);
//    }
//
//    @Override
//    public final ICondition isNull(final ColumnMeta<L> f) {
//        return this.setValue(f, Operation.IS_NULL);
//    }
//
//    @Override
//    public final ICondition isNotNull(final ColumnMeta<L> f) {
//        return this.setValue(f, Operation.IS_NOT_NULL);
//    }
//
//    @Override
//    public ISql limit(int i) {
//        // TODO implementation
//        return null;
//    }
//
////    @Override
////    public final String toString() {
////        final StringBuilder builder = new StringBuilder();
////        /*if (where != null) {
////            builder.append(where);
////        } else*/ if (joint != null) {
////            builder.append(joint);
////        }
////        if (condition != null) {
////            builder.append(condition);
////        }
////        return builder.toString();
////    }
//
//    @Override
//    public void extractBindVariables(Map<String, ? super Object> vars) {
//
//    }
//
//    @Override
//    public String getRepresentation() {
//        return operator.build(left, right);
//    }
//
//    /**
//     * Operation enum.
//     */
//    private enum Operation {
//
//        /** eq template. */
//        EQ("{{f}} = {{v}}"),
//        /** not eq template. */
//        NOT_EQ("{{f}} != {{v}}"),
//        /** gt template. */
//        GT("{{f}} > {{v}}"),
//        /** lt template. */
//        LT("{{f}} < {{v}}"),
//        /** ge template. */
//        GE("{{f}} >= {{v}}"),
//        /** le template. */
//        LE("{{f}} <= {{v}}"),
//        /** in template. */
//        IN("{{f}} in ({{v}})"),
//        /** not in template. */
//        NOT_IN("{{f}} not in ({{v}})"),
//        /** exists template. */
//        EXISTS("exists ({{v}})"),
//        /** not exists template. */
//        NOT_EXISTS("not exists ({{v}})"),
//        /** is null template. */
//        IS_NULL("{{f}} is null"),
//        /** is not null template. */
//        IS_NOT_NULL("{{f}} is not null");
//
//        /** */
//        private String operation;
//
//        /**
//         * @param anOperation operation
//         */
//        Operation(final String anOperation) {
//            this.operation = anOperation;
//        }
//
//        /**
//         * build template with condition data.
//         *
//         * @param f column name
//         * @param v value
//         * @return template converted with correct formatted value
//         */
//        private <R> String build(final ColumnMeta f, final R[] v) {
//            return operation
//                    .replace("{{f}}", f.getRepresentation())
//                    .replace("{{v}}", SQLUtils.SQLValue.toSQL(v));
//        }
//
//        /**
//         * build template for column.
//         *
//         * @param f column name
//         * @return template converted with correct formatted value
//         */
//        private String build(final ColumnMeta f) {
//            return operation.replace("{{f}}", f.getRepresentation());
//        }
//    }
}
