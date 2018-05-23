import org.fostash.atomic.metamodel.ColumnMeta;
import org.fostash.atomic.metamodel.TableMeta;

public final class PersonEntity {

    public static final TableMeta tableName = (TableMeta) () -> "PERSON";
    public static final ColumnMeta<Long> id = (ColumnMeta<Long>) () -> "ID";
    public static final ColumnMeta<String> name = (ColumnMeta<String>) () -> "FIRST_NAME";
    public static final ColumnMeta<String> surname = (ColumnMeta<String>) () -> "LAST_NAME";
//    public static final ColumnMeta<Date> birthday = (ColumnMeta<Date>) () -> "BIRTHDAY";

    public static ColumnMeta<Long> id(final String alias) {
        return new ColumnMeta<Long>() {
            @Override
            public String getName() {
                return "ID";
            }

            @Override
            public String getAlias() {
                return alias;
            }
        };
    }

    public static ColumnMeta<String> name(final String alias) {
        return new ColumnMeta<String>() {
            @Override
            public String getName() {
                return "FIRST_NAME";
            }

            @Override
            public String getAlias() {
                return alias;
            }
        };
    }

    public static ColumnMeta<String> surname(final String alias) {
        return new ColumnMeta<String>() {
            @Override
            public String getName() {
                return "LAST_NAME";
            }

            @Override
            public String getAlias() {
                return alias;
            }
        };
    }
}