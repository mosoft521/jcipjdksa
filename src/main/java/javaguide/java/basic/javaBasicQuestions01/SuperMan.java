package javaguide.java.basic.javaBasicQuestions01;

public class SuperMan extends Hero {
    @Override
    public String name() {
        return "超人";
    }

    public Hero hero() {
        return new Hero();
    }
}
