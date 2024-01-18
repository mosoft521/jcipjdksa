package generics2;

// 同上面的Test2
public class TestMethod4<T> {
    // 泛型类定义的类型参数 T 不能在静态方法中使用
    // 但可以将静态方法声明为泛型方法，方法中便可以使用其声明的类型参数了
    public static <E> E show(E one) {
        return null;
    }
}