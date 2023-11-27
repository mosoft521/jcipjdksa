package javaguide.java.basic.javaBasicQuestions03;

public class GeneratorImpl<T> implements Generator<T> {
    @Override
    public T method() {
        return null;
    }

    public static void main(String[] args) {
        Generator<String> generator = new GeneratorImpl<>();
        System.out.println(generator.method());//null
    }
}