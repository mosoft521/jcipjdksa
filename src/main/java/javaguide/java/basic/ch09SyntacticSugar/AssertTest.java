package javaguide.java.basic.ch09SyntacticSugar;

public class AssertTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        assert a == b;
        System.out.println("公众号：Hollis");
        assert a != b : "Hollis";
        System.out.println("博客：www.hollischuang.com");
    }
}
/*
公众号：Hollis
博客：www.hollischuang.com
 */