package javaguide.java.newFeatures.modern;

public class LambdaDemo2 {
    public static void main(String[] args) {
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));// 3
    }
}