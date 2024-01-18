package generics2;

import java.util.ArrayList;

public class GenericType2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayInteger = new ArrayList<Integer>();// 设置验票系统
        arrayInteger.add(111);// 观众进场，验票系统验票，门票会被收走（类型擦除）
        Integer n = arrayInteger.get(0);// 获取观众信息，编译器会进行强制类型转换
        System.out.println(n);
    }
}