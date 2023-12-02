//package javaguide.java.newFeatures.modern;
//
//public class LambdaDemo3 {
//    public static void main(String[] args) {
//        int num = 1;
//        Converter<Integer, String> stringConverter =
//                (from) -> String.valueOf(from + num);
//        System.out.println(stringConverter.convert(2));// 3
//        num = 3;//从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
//    }
//}