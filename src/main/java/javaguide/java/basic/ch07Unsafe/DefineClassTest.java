//package javaguide.java.basic.ch07Unsafe;
////JDK 1.8
//import sun.misc.Unsafe;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.lang.reflect.Field;
//
//public class DefineClassTest {
//    public static void main(String[] args) {
//        Unsafe unsafe = reflectGetUnsafe();
//        assert unsafe != null;
//        String fileName="E:\\ws-ij-alvin-git-tmp\\jcipjdksa-alvin\\target\\classes\\javaguide\\java\\basic\\ch07Unsafe\\User.class";
//        File file = new File(fileName);
//        try(FileInputStream fis = new FileInputStream(file)) {
//            byte[] content=new byte[(int)file.length()];
//            fis.read(content);
//            Class clazz = unsafe.defineClass(null, content, 0, content.length, null, null);
//            Object o = clazz.newInstance();
//            Object age = clazz.getMethod("getAge").invoke(o, null);
//            System.out.println(age);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static Unsafe reflectGetUnsafe() {
//        try {
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            return (Unsafe) field.get(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
///*
//0
// */