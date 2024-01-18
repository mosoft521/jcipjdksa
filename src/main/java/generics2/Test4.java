package generics2;

import java.util.ArrayList;

public class Test4 {
    public static void main(String[] args) {
        // 创建一个 ArrayList<Integer> 集合
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        // 将 ArrayList<Integer> 传入 printIntVal() 方法
        printIntVal(integerList);

        // 创建一个 ArrayList<Float> 集合
        ArrayList<Float> floatList = new ArrayList<>();
        floatList.add((float) 1.0);
        floatList.add((float) 2.0);
        // 将 ArrayList<Float> 传入 printIntVal() 方法
        printIntVal(floatList);
    }

    public static void printIntVal(ArrayList<? extends Number> list) {
        // 遍历传入的集合，并输出集合中的元素
        for (Number number : list) {
            System.out.print(number.intValue() + " ");
        }
        System.out.println();
    }
}