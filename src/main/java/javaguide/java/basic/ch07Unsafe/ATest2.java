package javaguide.java.basic.ch07Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ATest2 {
    public static void objTest() throws Exception {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        //编译报错：'APrivateConstructor()' has private access in 'javaguide.java.basic.ch07Unsafe.APrivateConstructor'
//        APrivateConstructor a1 = new APrivateConstructor();
//        System.out.println(a1.getB());
        //运行报错：Exception in thread "main" java.lang.IllegalAccessException:
        // Class javaguide.java.basic.ch07Unsafe.ATest2 can not access a member of class
        // javaguide.java.basic.ch07Unsafe.APrivateConstructor with modifiers "private"
//        APrivateConstructor a2 = APrivateConstructor.class.newInstance();
//        System.out.println(a2.getB());
        APrivateConstructor a3 = (APrivateConstructor) unsafe.allocateInstance(APrivateConstructor.class);
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
0
 */