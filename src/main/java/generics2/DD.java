package generics2;

// DD 类定义为 泛型类，则不需要确定 接口的类型参数
// 但 DD 类定义的类型参数要和接口中类型参数的一致
public abstract class DD<U, R> implements IUsb<U, R> {
    //...
}