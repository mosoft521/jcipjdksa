package javaguide.java.basic.javaBasicQuestions02;

public class AddressAndPersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
        System.out.println(person1.getAddress() == person1Copy.getAddress());// true
    }
}