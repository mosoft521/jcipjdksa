package generics2;

public class Test3<U> {
    // 该方法只是使用了泛型类定义的类型参数，不是泛型方法，是普通方法
    public void testMethod(U u) {
        System.out.println(u);
    }

    // <T> 真正声明了下面的方法是一个普通泛型方法【不是静态泛型方法】
    public <T> T testMethod1(T t) {
        return t;
    }
}