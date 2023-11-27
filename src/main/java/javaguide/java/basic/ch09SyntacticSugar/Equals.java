package javaguide.java.basic.ch09SyntacticSugar;

public class Equals {
    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;
        Integer c = 100;
        Integer d = 100;
        System.out.println("a == b is " + (a == b));
        System.out.println(("c == d is " + (c == d)));
    }
}
/*
a == b is false
c == d is true
 */