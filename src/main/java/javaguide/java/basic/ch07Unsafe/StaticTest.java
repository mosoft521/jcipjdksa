package javaguide.java.basic.ch07Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class StaticTest {
    private static void staticTest() throws Exception {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        User user = new User();
        // 也可以用下面的语句触发类初始化
        // 1.
        //unsafe.ensureClassInitialized(User.class);
        // 2.
        //System.out.println(User.name);
        System.out.println(unsafe.shouldBeInitialized(User.class));
        Field nameField = User.class.getDeclaredField("name");
        Object fieldBase = unsafe.staticFieldBase(nameField);
        long fieldOffset = unsafe.staticFieldOffset(nameField);
        Object object = unsafe.getObject(fieldBase, fieldOffset);
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        staticTest();
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
false
Hydra
如果删除创建 User 对象的语句
true
null
 */