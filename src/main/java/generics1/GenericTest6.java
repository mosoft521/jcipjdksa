package generics1;


public class GenericTest6<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericTest6<String> test = new GenericTest6<>();
        test.set("mosoft521@gamil");
        String s = test.get();
        System.out.println(s);// mosoft521@gamil
    }
}