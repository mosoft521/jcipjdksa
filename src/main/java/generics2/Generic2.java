package generics2;

public class Generic2<T> {
    // key 这个成员变量的数据类型为 T, T 的类型由外部传入
    private T key;

    // 泛型构造方法形参 key 的类型也为 T，T 的类型由外部传入
    public Generic2(T key) {
        this.key = key;
    }

    // 泛型方法 getKey 的返回值类型为 T，T 的类型由外部指定
    public T getKey() {
        return key;
    }

    // 泛型方法 setKey 的形参 key 的类型也为 T，T 的类型由外部传入
    public void setKey(T key) {
        this.key = key;
    }
}