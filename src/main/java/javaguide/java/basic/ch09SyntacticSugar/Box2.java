package javaguide.java.basic.ch09SyntacticSugar;

public class Box2 {
    public static void main(String[] args) {
        int i = 10;
        Integer n = Integer.valueOf(i);
        System.out.println(n);
    }
}