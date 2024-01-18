package generics2;

public class Test2<T> {
    // 泛型类定义的类型参数 T 不能在静态方法中使用
    public static <E> E show(E one) { // 这是正确的，因为 E 是在静态方法签名中新定义的类型参数
        return null;
    }
}