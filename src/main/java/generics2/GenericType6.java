// package generics2;
//
// import java.util.ArrayList;
//
// public class GenericType6 {
//     public static void main(String[] args) {
//         // 创建一个 ArrayList<Integer> 集合
//         ArrayList<Integer> integerList = new ArrayList<>();
//
//         // 添加一个 Integer 对象
//         integerList.add(new Integer(123));
//
//         // “向上转型”为 ArrayList<Number>
//         ArrayList<Number> numberList = integerList;
//
//         // 添加一个 Float 对象，Float 也是 Number 的子类，编译器不报错
//         numberList.add(new Float(12.34));
//
//         // 从 ArrayList<Integer> 集合中获取索引为 1 的元素（即添加的 Float 对象）：
//         Integer n = integerList.get(1); // ClassCastException，运行出错
//     }
// }