import org.fostash.atomic.metamodel.ColumnMeta;
import org.fostash.atomic.metamodel.TableMeta;

public final class PersonEntity {

    public static final TableMeta tableName = (TableMeta) () -> "PERSON";
    public static final ColumnMeta<Long> id = ColumnMeta.of("ID");
    public static final ColumnMeta<String> name = ColumnMeta.of("FIRST_NAME");
    public static final ColumnMeta<String> surname = ColumnMeta.of("LAST_NAME");
//    public static final ColumnMeta<Date> birthday = (ColumnMeta<Date>) () -> "BIRTHDAY";

    public static ColumnMeta<Long> id(final String tableAlias) {
        return ColumnMeta.of("ID", tableAlias);
    }

    public static ColumnMeta<String> name(final String tableAlias) {
        return ColumnMeta.of("FIRST_NAME", tableAlias);
    }

    public static ColumnMeta<String> surname(final String tableAlias) {
        return ColumnMeta.of("LAST_NAME", tableAlias);
    }
}