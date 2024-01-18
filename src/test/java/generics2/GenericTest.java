package generics2;

import org.junit.jupiter.api.Test;

public class GenericTest {
    @Test
    public void test() {
        Generic<String> generic = new Generic<>();// 传入 String 类型【这里必须要有无参的默认构造函数】

        // <> 中什么都不传入，等价于 Generic<Object> generic = new Generic<>();
        Generic generic2 = new Generic();
    }
}