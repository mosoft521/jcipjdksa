package generics2;

// 在继承泛型接口时，必须确定泛型接口的类型参数
interface IA extends IUsb<String, Double> {
    //...
}

// 当去实现 IA 接口时，因为 IA 在继承 IUsu 接口时，指定了类型参数 U 为 String，R 为 Double
// 所以在实现 IUsb 接口的方法时，使用 String 替换 U,用 Double 替换 R
public class AA implements IA {
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double d) {
        //...
    }
}