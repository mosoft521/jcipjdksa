package javaguide.java.newFeatures.java17;

public class NullDemo {
    // Old code
    static void testFooBar1(String s) {
        if (s == null) {
            System.out.println("oops!");
            return;
        }
        switch (s) {
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    // New code
    static void testFooBar2(String s) {
        switch (s) {
            case null -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    public static void main(String[] args) {
        String s = null;
        testFooBar1(s);//oops!
        testFooBar2(s);//Oops
    }
}