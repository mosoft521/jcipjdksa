package javaguide.java.basic.ch07Unsafe;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Slf4j
public class SysInfoTest {
    public static void main(String[] args) {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;

        System.out.println("系统指针的大小: " + unsafe.addressSize());
        System.out.println("内存页的大小: " + unsafe.pageSize());
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
系统指针的大小: 8
内存页的大小: 4096
 */