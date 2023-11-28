package javaguide.java.collection.caution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class List2MapCaution {
    public static void main(String[] args) {
        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack", "18163138123"));
        bookList.add(new Person("martin", null));
        // 空指针异常
        bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));
    }
}
/*
Exception in thread "main" java.lang.NullPointerException
 */