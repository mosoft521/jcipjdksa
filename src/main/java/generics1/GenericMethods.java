package generics1;

public class GenericMethods {

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("字符串");
        gm.f(666);
    }
}
/*
java.lang.String
java.lang.Integer
 */