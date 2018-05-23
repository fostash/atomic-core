package org.fostash.atomic.dsl.ansi;

/**
 *
 * Created by Fausto on 23/04/16.
 */
public class Update /*implements IUpdate*/ {

//    /** table field. */
//    private final IFrom.ITable table;
//    /** values field. */
//    private List<ISet> values = new ArrayList<>();
//
//    /**
//     * @param aTable aTable
//     */
//    public Update(final IFrom.ITable aTable) {
//        this.table = aTable;
//    }
//
//    @Override
//    public final IWhere set(final ISet...set) {
//        Objects.requireNonNull(set);
//        values.addAll(Arrays.asList(set));
//        return Factory.where(this);
//    }
//
//    @Override
//    public final String toString() {
//        return "UPDATE "
//                + table
//                + " SET "
//                + values.stream()
//                        .map(SQLUtils.SQLValue::toSQL)
//                        .collect(Collectors.joining(", "));
//    }
//
//    /**
//     * ISet implementation.
//     */
//    public static class Set implements ISet {
//
//        /** k field */
//        public final String k;
//        /** v field */
//        public final Object v;
//
//        /**
//         * @param key key
//         * @param value value
//         */
//        private Set(final String key, final Object value) {
//            this.k = key;
//            this.v = value;
//        }
//
//        /**
//         * @param key key
//         * @param value value
//         * @return ISet interface
//         */
//        public static ISet set(final String key, final Object value) {
//            return new Set(key, value);
//        }
//
//        @Override
//        public String toString() {
//            return k + " = " + SQLUtils.SQLValue.toSQL(v);
//        }
//    }
}
