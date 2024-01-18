package generics2;

// 实现泛型接口时没有确定类型参数，则默认为 Object
// 建议直接写成 IUsb<Object, Object>
public class CC implements IUsb {// 等价 class CC implements IUsb<Object, Object>

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {
        //...
    }
}