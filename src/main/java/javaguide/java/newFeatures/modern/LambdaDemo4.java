package javaguide.java.newFeatures.modern;

public class LambdaDemo4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        System.out.println(stringConverter1.convert(2));// 2

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        System.out.println(stringConverter2.convert(2));// 2
    }

    public static void main(String[] args) {
        LambdaDemo4 lambdaDemo4 = new LambdaDemo4();
        lambdaDemo4.testScopes();
    }
}