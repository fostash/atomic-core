package org.fostash.atomic.dsl.ansi;

/**
 *
 * Created by Fausto on 25/04/16.
 */
public class Insert /*implements IInsert*/ {

//    /**  table field. */
//    private IFrom.ITable table;
//    /** column list field. */
//    private final List<IColumn> columns = new ArrayList<>();
//    /** value to insert list field. */
//    private final List<Object> values = new LinkedList<>();
//
//    @Override
//    public IInsert into(final IFrom.ITable iTable, final IColumn... iColumns) {
//        this.table = iTable;
//        if (Objects.nonNull(iColumns) && iColumns.length > 0) {
//            columns.addAll(Arrays.asList(iColumns));
//        }
//        return this;
//    }
//
//    @Override
//    public final IInsert values(final Object...objects) {
//        if (objects.length > 0) {
//            values.addAll(Arrays.asList(objects));
//        } else {
//            throw new SqlBuilderException("no values defined for insert");
//        }
//        return this;
//    }
//
//    /**
//     * @return sql insert string
//     */
//    @Override
//    public final String toString() {
//        return "INSERT INTO " + table
//                + " ("
//                + columns.stream().map(IColumn::getName).collect(Collectors.joining(", "))
//                + ") VALUES ("
//                + values.stream().map(SQLUtils.SQLValue::toSQL).collect(Collectors.joining(", "))
//                + ");";
//    }
}
