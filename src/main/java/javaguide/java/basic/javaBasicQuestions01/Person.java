package javaguide.java.basic.javaBasicQuestions01;

public class Person {
    public void method() {
        //......
    }

    public static void staicMethod() {
        //......
    }

    public static void main(String[] args) {
        Person person = new Person();
        // 调用实例方法
        person.method();
        // 调用静态方法
        Person.staicMethod();
    }
}