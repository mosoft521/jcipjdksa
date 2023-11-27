package javaguide.java.basic.ch09SyntacticSugar;

public class ConditionalCompilation {
    public static void main(String[] args) {
        final boolean DEBUG = true;
        if (DEBUG) {
            System.out.println("Hello, DEBUG!");
        }

        final boolean ONLINE = false;

        if (ONLINE) {
            System.out.println("Hello, ONLINE!");
        }
    }
}
/*
Hello, DEBUG!
 */