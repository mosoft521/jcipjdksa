package javaguide.java.newFeatures.modern;

public class ConverterDemo2 {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());   //class java.lang.Integer
    }
}