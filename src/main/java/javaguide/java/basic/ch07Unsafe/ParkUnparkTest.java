package javaguide.java.basic.ch07Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class ParkUnparkTest {
    public static void main(String[] args) {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        Thread mainThread = Thread.currentThread();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("subThread try to unpark mainThread");
                unsafe.unpark(mainThread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("park main mainThread");
        unsafe.park(false, 0L);
        System.out.println("unpark mainThread success");
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
park main mainThread
subThread try to unpark mainThread
unpark mainThread success
 */