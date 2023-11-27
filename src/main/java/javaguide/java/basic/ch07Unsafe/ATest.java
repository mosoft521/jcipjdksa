package javaguide.java.basic.ch07Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ATest {
    public static void objTest() throws Exception {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        A a1 = new A();
        System.out.println(a1.getB());
        A a2 = A.class.newInstance();
        System.out.println(a2.getB());
        A a3 = (A) unsafe.allocateInstance(A.class);
        System.out.println(a3.getB());
    }

    public static void main(String[] args) throws Exception {
        objTest();
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
/*
1
1
0
 */