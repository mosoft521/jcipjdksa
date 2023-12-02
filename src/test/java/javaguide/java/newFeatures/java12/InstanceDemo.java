package javaguide.java.newFeatures.java12;

import org.junit.jupiter.api.Test;

public class InstanceDemo {
    @Test
    public void instanceofTest() {
        Object obj = "我是字符串";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str);//我是字符串
        }
    }

    @Test
    public void instanceofTest2() {
        Object obj = "我是字符串";
        if (obj instanceof String str) {
            System.out.println(str);//我是字符串
        }
    }
}