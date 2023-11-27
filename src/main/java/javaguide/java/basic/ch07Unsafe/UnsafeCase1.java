package javaguide.java.basic.ch07Unsafe;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Slf4j
public class UnsafeCase1 {

    // 单例对象
    private static final Unsafe unsafe = reflectGetUnsafe();

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

    private static void memoryTest() {
        assert unsafe != null;
        int size = 4;
        long addr = unsafe.allocateMemory(size);
        long addr3 = unsafe.reallocateMemory(addr, size * 2);
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);
        try {
            unsafe.setMemory(null, addr, size, (byte) 1);
            for (int i = 0; i < 2; i++) {
                unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
            }
            System.out.println(unsafe.getInt(addr));
            System.out.println(unsafe.getLong(addr3));
        } finally {
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }

    public static void main(String[] args) {
        memoryTest();
    }
}
/*
addr:  2222495182832
addr3: 2222495183344
16843009
72340172838076673
 */