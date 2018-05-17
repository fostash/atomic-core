import org.fostash.atomic.metamodel.ColumnMeta;
import org.fostash.atomic.metamodel.TableMeta;

import java.time.LocalDate;

public final class PersonEntity {

    public static final TableMeta tableName = (TableMeta) () -> "PERSON";
    public static final ColumnMeta<Long> id = (ColumnMeta<Long>) () -> "PERSON_K";
    public static final ColumnMeta<String> name = (ColumnMeta<String>) () -> "NAME";
    public static final ColumnMeta<String> surname = (ColumnMeta<String>) () -> "SURNAME";
    public static final ColumnMeta<LocalDate> birthday = (ColumnMeta<LocalDate>) () -> "BIRTHDAY";
}