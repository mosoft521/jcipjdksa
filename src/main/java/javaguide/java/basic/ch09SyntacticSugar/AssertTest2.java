package javaguide.java.basic.ch09SyntacticSugar;

public class AssertTest2 {
    public static void main(String args[]) {
        int a = 1;
        int b = 1;
        if (!$assertionsDisabled && a != b)
            throw new AssertionError();
        System.out.println("\u516C\u4F17\u53F7\uFF1AHollis");
        if (!$assertionsDisabled && a == b) {
            throw new AssertionError("Hollis");
        } else {
            System.out.println("\u535A\u5BA2\uFF1Awww.hollischuang.com");
            return;
        }
    }
    // 这里编译报错，为了通过编译，dummy一下
    // static final boolean $assertionsDisabled = !javaguide/java/basic/ch09SyntacticSugar/AssertTest.desiredAssertionStatus();
    static final boolean $assertionsDisabled = true;
}