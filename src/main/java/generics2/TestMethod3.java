package generics2;

public class TestMethod3<T> {
    public void testMethod(T t) {
        System.out.println(t);
    }

    public <T> T testMethod1(T t) {
        return t;
    }
}