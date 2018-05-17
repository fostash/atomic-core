import org.fostash.atomic.dsl.ISelect;

public class Example {

    public Example() {

        ISelect select = null;

        select.select(PersonEntity.name)
                .from(PersonEntity.tableName)
                .innerJoin(AddressEntity.tableName).on(PersonEntity.id, AddressEntity.personEntity) // TODO: on with more than one condition
                .where().eq(PersonEntity.name, "Fausto");
    }

    public static void main(String[] args) {
        new Example();
    }
}
