package javaguide.java.newFeatures.modern;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get());   // Person(firstName=null, lastName=null)
    }
}