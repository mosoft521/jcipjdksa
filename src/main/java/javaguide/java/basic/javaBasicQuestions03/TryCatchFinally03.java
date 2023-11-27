package javaguide.java.basic.javaBasicQuestions03;

public class TryCatchFinally03 {
    public static void main(String[] args) {
        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
            // 终止当前正在运行的Java虚拟机
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }
    }
}
/*
Try to do something
Catch Exception -> RuntimeException
 */