package generics1;

public class StringGenerator implements Generator<String> {

    @Override
    public String next() {
        return "测试泛型接口";
    }
}