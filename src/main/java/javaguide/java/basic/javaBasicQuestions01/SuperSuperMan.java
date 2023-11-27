package javaguide.java.basic.javaBasicQuestions01;

public class SuperSuperMan extends SuperMan {
    public String name() {
        return "超超人";
    }

    @Override
    public SuperMan hero() {
        return new SuperMan();
    }

    public static void main(String[] args) {
        Hero ssm = new SuperSuperMan();
        System.out.println(ssm.name());
        System.out.println(((SuperSuperMan) ssm).hero().name());
        System.out.println(((SuperSuperMan) ssm).hero().hero().name());
    }
}
/*
超超人
超人
英雄
 */