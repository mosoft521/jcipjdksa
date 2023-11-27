package javaguide.java.basic.javaBasicQuestions03;

public class GeneratorImpl2<T> implements Generator<String> {
    @Override
    public String method() {
        return "hello";
    }

    public static void main(String[] args) {
        Generator<String> generator = new GeneratorImpl2<>();
        System.out.println(generator.method());//hello
    }
}