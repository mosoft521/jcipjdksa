package javaguide.java.basic.javaBasicQuestions02;

public class Address implements Cloneable {
    private String name;
    // 省略构造函数、Getter&Setter方法


    public Address(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}