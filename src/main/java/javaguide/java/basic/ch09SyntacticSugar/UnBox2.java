package javaguide.java.basic.ch09SyntacticSugar;

public class UnBox2 {
    public static void main(String args[]) {
        Integer i = Integer.valueOf(10);
        int n = i.intValue();
        System.out.println(n);
    }
}