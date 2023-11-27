package javaguide.java.basic.ch01ValuePassing;

public class ParameterAndArgument {
    public static void main(String[] args) {
        String hello = "Hello!";
        // hello 为实参
        sayHello(hello);
    }

    // str 为形参
    public static void sayHello(String str) {
        System.out.println(str);//Hello!
    }
}
