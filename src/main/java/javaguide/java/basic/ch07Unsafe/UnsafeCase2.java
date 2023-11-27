package javaguide.java.basic.ch07Unsafe;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Slf4j
public class UnsafeCase2 {

    public static void main(String[] args) {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        while (true) {
            boolean flag = changeThread.isFlag();
            //如果注释掉下行代码，那么主线程将无法感知到flag发生的变化，会一直在while中循环
            unsafe.loadFence(); //加入读内存屏障
            if (flag) {
                System.out.println("detected flag changed");
                break;
            }
        }
        System.out.println("main thread end");
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
/*
subThread change flag to:false
detected flag changed
main thread end
 */