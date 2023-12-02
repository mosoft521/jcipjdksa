package javaguide.java.newFeatures.modern;

public class PersonDemo {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);//Person(firstName=Peter, lastName=Parker)
    }
}