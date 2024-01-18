package generics2;

interface IUsb<U, R> {

    int n = 10;
    // U name;// 报错！ 接口中的属性默认是静态的，因此不能使用类型参数声明

    R get(U u);// 普通方法中，可以使用类型参数

    void hi(R r);// 抽象方法中，可以使用类型参数

    // 在jdk8 中，可以在接口中使用默认方法, 默认方法可以使用泛型接口的类型参数
    default R method(U u) {
        return null;
    }
}