package javaguide.java.basic.javaBasicQuestions02;

public class AddressAndPersonTest2 {
    public static void main(String[] args) {
        PersonDeepCopy personDeepCopy = new PersonDeepCopy(new Address("武汉"));
        PersonDeepCopy personDeepCopy2 = personDeepCopy.clone();
        System.out.println(personDeepCopy.getAddress() == personDeepCopy2.getAddress());// false
    }
}