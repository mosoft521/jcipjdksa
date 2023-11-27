package javaguide.java.basic.javaBasicQuestions03;

public class TryCatchFinally01 {
    public static void main(String[] args) {
        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }
}
/*
Try to do something
Catch Exception -> RuntimeException
Finally
 */