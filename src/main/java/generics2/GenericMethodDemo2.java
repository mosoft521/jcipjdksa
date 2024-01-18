package generics2;

public class GenericMethodDemo2 {

    // 这是一个简单的静态泛型方法
    public static <T> T add(T x, T y) {
        return y;
    }

    public static void main(String[] args) {
        // 一、不显式地指定类型参数
        //（1）传入的两个实参都是 Integer，所以泛型方法中的<T> == <Integer>
        int i = GenericMethodDemo2.add(1, 2);

        //（2）传入的两个实参一个是 Integer，另一个是 Float，
        // 所以<T>取共同父类的最小级，<T> == <Number>
        Number f = GenericMethodDemo2.add(1, 1.2);

        // 传入的两个实参一个是 Integer，另一个是 String，
        // 所以<T>取共同父类的最小级，<T> == <Object>
        Object o = GenericMethodDemo2.add(1, "asd");

        // 二、显式地指定类型参数
        //（1）指定了<T> = <Integer>，所以传入的实参只能为 Integer 对象
        int a = GenericMethodDemo2.<Integer>add(1, 2);

        //（2）指定了<T> = <Integer>，所以不能传入 Float 对象
        // int b = GenericMethodDemo2.<Integer>add(1, 2.2);// 编译错误

        //（3）指定<T> = <Number>，所以可以传入 Number 对象
        // Integer 和 Float 都是 Number 的子类，因此可以传入两者的对象
        Number c = GenericMethodDemo2.<Number>add(1, 2.2);
    }
}