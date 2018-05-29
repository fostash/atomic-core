public class Example {

    public Example() {
        /*final IQueryFactory qf = new Factory();
        final IQuery q = qf.createQuery();*/
        ///q.select(PersonEntity.id.toLowerCase().as("persona_id"), PersonEntity.name.as("first_name"), PersonEntity.surname.as("last_name"))
         //       .from(PersonEntity.tableName, "p");

        System.out.println(PersonEntity.id.toLowerCase().as("persona_id").getRepresentation());

//        select.select(PersonEntity.name)
//                .from(PersonEntity.tableName)
//                .innerJoin(AddressEntity.tableName).on(PersonEntity.id, AddressEntity.personEntity) // TODO: on with more than one condition
//                .where().eq(PersonEntity.name, "Fausto");
    }

    public static void main(String[] args) {
        new Example();
    }
}
