package javaguide.java.newFeatures.modern;

import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
//        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Comparator<Person> comparator = Comparator.comparing(p -> p.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2));// 9 【>0】
        System.out.println(comparator.reversed().compare(p1, p2));// -9 【<0】
    }
}