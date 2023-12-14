package org.apache.commons.lang3;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
    private static String sAbc = "111";
    private String abc = "123";

    @Test
    public void fieldTest() throws Exception {
        ReflectTest reflectTest = new ReflectTest();
        // 反射获取对象实例属性的值
        // 原生写法
        Field abcField = reflectTest.getClass().getDeclaredField("abc");
        abcField.setAccessible(true);// 设置访问级别，如果private属性不设置则访问会报错
        String value = (String) abcField.get(reflectTest);
        System.out.println(value);// 123
        // commons写法
        String value2 = (String) FieldUtils.readDeclaredField(reflectTest, "abc", true);
        System.out.println(value2);//123
        // 方法名如果不含Declared会向父类上一直查找
    }

    @Test
    public void fieldTest2() throws Exception {
        ReflectTest reflectTest = new ReflectTest();
        // 反射获取对象属性的值
        String value2 = (String) FieldUtils.readField(reflectTest, "abc", true);
        System.out.println(value2);//123
        // 反射获取类静态属性的值
        String value3 = (String) FieldUtils.readStaticField(ReflectTest.class, "sAbc", true);
        System.out.println(value3);//111
        // 反射设置对象属性值
        FieldUtils.writeField(reflectTest, "abc", "newValue", true);
        // 反射设置类静态属性的值
        FieldUtils.writeStaticField(ReflectTest.class, "sAbc", "newStaticValue", true);
        // 反射获取对象属性的值
        value2 = (String) FieldUtils.readField(reflectTest, "abc", true);
        System.out.println(value2);//newValue
        // 反射获取类静态属性的值
        value3 = (String) FieldUtils.readStaticField(ReflectTest.class, "sAbc", true);
        System.out.println(value3);//newStaticValue
    }

    @Test
    public void annotationTest() {
        // 获取被Test注解标识的方法
        // 原生写法
        List<Method> annotatedMethods = new ArrayList<Method>();
        for (Method method : ReflectTest.class.getMethods()) {
            if (method.getAnnotation(Test.class) != null) {
                annotatedMethods.add(method);
            }
        }
        // commons写法
        Method[] annotatedMethods2 = MethodUtils.getMethodsWithAnnotation(ReflectTest.class, Test.class);

        for (Method m : annotatedMethods) {
            System.out.println(m.getName());//fieldTest fieldTest2  annotationTest
        }
        for (Method m : annotatedMethods2) {
            System.out.println(m.getName());//fieldTest fieldTest2  annotationTest
        }
    }

    public static void testStaticMethod(String param1) {
        System.out.println(param1);
    }

    public void testMethod(String param1) {
        System.out.println(param1);
    }

    @Test
    public void invokeTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 调用函数"testMethod"
        ReflectTest reflectTest = new ReflectTest();
        // 原生写法
        //Method testMethod = reflectTest.getClass().getDeclaredMethod("testMethod");//NoSuchMethodException，因为testMethod有参数
        Method testMethod = reflectTest.getClass().getDeclaredMethod("testMethod", String.class);
        testMethod.setAccessible(true); // 设置访问级别，如果private函数不设置则调用会报错
        testMethod.invoke(reflectTest, "testParam");//testParam
        // commons写法
        //MethodUtils.invokeExactMethod(reflectTest, "testMethod", "testParam");//NoSuchMethodException，因为①testMethod有参数；②MethodUtils下的方法只能调用public的方法
        Object[] args = new String[]{"testParam2"};
        Class<?>[] parameterTypes = new Class[]{String.class};
        MethodUtils.invokeExactMethod(reflectTest, "testMethod", args, parameterTypes);
        MethodUtils.invokeExactMethod(reflectTest, "testMethod", "testParam3");//private改为public，OK

        // ---------- 类似方法 ----------
        // 调用static方法
        args = new String[]{"testParam4"};
        MethodUtils.invokeExactStaticMethod(ReflectTest.class, "testStaticMethod", args, parameterTypes);
        // 调用方法(含继承过来的方法)
        MethodUtils.invokeMethod(reflectTest, "testMethod", "testParam5");
        // 调用static方法(当前不存在则向父类寻找匹配的静态方法)
        MethodUtils.invokeStaticMethod(ReflectTest.class, "testStaticMethod", "testParam6");
    }
}