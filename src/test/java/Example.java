import org.fostash.atomic.dsl.IQuery;
import org.fostash.atomic.dsl.IQueryFactory;
import org.fostash.atomic.dsl.ansi.Factory;

public class Example {

    public Example() {
        final IQueryFactory qf = new Factory();
        final IQuery q = qf.createQuery();
        ;

        System.out.println(
                q.select(
                        PersonEntity.id("p").as("persona_id"),
                        qf.toLowerCase(PersonEntity.name).as("first_name"),
                        qf.toLowerCase(PersonEntity.surname).as("last_name")
                ).from(PersonEntity.tableName.as("p").innerJoin(AddressEntity.tableName)
                        .on(PersonEntity.id, AddressEntity.personEntity)).getRepresentation()
        );

//        select.select(PersonEntity.name)
//                .from(PersonEntity.tableName)
//                .innerJoin(AddressEntity.tableName).on(PersonEntity.id, AddressEntity.personEntity) // TODO: on with more than one condition
//                .where().eq(PersonEntity.name, "Fausto");
    }

    public static void main(String[] args) {
        new Example();
    }
}
