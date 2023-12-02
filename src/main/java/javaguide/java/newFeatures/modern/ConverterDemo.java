package javaguide.java.newFeatures.modern;

public class ConverterDemo {
    public static void main(String[] args) {
        // 将数字字符串转换为整数类型
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass()); //class java.lang.Integer
    }
}