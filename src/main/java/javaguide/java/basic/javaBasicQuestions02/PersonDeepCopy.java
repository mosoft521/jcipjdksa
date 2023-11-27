package javaguide.java.basic.javaBasicQuestions02;

public class PersonDeepCopy implements Cloneable {
    private Address address;
    // 省略构造函数、Getter&Setter方法

    public PersonDeepCopy(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public PersonDeepCopy clone() {
        try {
            PersonDeepCopy personDeepCopy = (PersonDeepCopy) super.clone();
            personDeepCopy.setAddress(personDeepCopy.getAddress().clone());
            return personDeepCopy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
