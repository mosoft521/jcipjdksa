package javaguide.java.basic.ch07Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CasTest {
    private volatile int a;

    public static void main(String[] args) {
        CasTest casTest = new CasTest();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                casTest.increment(i);
                System.out.print(casTest.a + " ");
            }
        }).start();
        new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                casTest.increment(i);
                System.out.print(casTest.a + " ");
            }
        }).start();
    }

    private void increment(int x) {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        while (true) {
            try {
                long fieldOffset = unsafe.objectFieldOffset(CasTest.class.getDeclaredField("a"));
                if (unsafe.compareAndSwapInt(this, fieldOffset, x - 1, x))
                    break;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
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
1 2 3 4 5 6 7 8 9
 */