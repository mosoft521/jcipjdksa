package javaguide.java.basic.javaBasicQuestions01;

public class FloatDoubleTest {
    public static void main(String[] args) {
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出 true

        Float i11 = 333f;
        Float i22 = 333f;
        System.out.println(i11 == i22);// 输出 false

        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出 false
    }
}
/*
true
false
false
 */