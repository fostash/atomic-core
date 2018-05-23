import org.fostash.atomic.dsl.IQuery;
import org.fostash.atomic.dsl.IQueryFactory;
import org.fostash.atomic.dsl.ansi.Factory;
import org.fostash.atomic.dsl.ansi.Query;

public class Example {

    public Example() {
        final IQueryFactory qf = new Factory();
        final IQuery q = qf.createQuery();
        q.select(PersonEntity.id("persona_id"), PersonEntity.name("first_name"), PersonEntity.surname("last_name")).from(PersonEntity.tableName, "p");

//        select.select(PersonEntity.name)
//                .from(PersonEntity.tableName)
//                .innerJoin(AddressEntity.tableName).on(PersonEntity.id, AddressEntity.personEntity) // TODO: on with more than one condition
//                .where().eq(PersonEntity.name, "Fausto");
    }

    public static void main(String[] args) {
        new Example();
    }
}
