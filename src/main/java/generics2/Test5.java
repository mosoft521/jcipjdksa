// package generics2;
//
// import java.util.ArrayList;
//
// public class Test5 {
//     public static void main(String[] args) {
//         ArrayList<? extends Number> list = new ArrayList();
//         list.add(new Integer(1));// 编译错误
//         list.add(new Float(1.0));// 编译错误
//         list.add(null);// 编译正确，但不建议这样使用
//     }
//
//     public static void fillNumList(ArrayList<? extends Number> list) {
//         list.add(new Integer(0));// 编译错误
//         list.add(new Float(1.0));// 编译错误
//         list.set(0, new Integer(2));// 编译错误
//         list.set(0, null);// 编译成功，但不建议这样使用
//     }
// }