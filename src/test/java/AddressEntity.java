import org.fostash.atomic.metamodel.ColumnMeta;
import org.fostash.atomic.metamodel.TableMeta;

public final class AddressEntity {

    public static final TableMeta tableName = (TableMeta) () -> "ADDRESS";

    public static final ColumnMeta<PersonEntity> personEntity = (ColumnMeta<PersonEntity>) () -> "PERSON_FK";
    public static final ColumnMeta<String> street= (ColumnMeta<String>) () -> "STREET_NAME";
    public static final ColumnMeta<Long> number = (ColumnMeta<Long>) () -> "NUMBER";
}