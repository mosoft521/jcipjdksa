package javaguide.java.basic.javaBasicQuestions03.dynamicProxyCGLib;

/**
 * CGLIB动态代理
 * https://javaguide.cn/java/basis/proxy.html#_3-2-cglib-%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E6%9C%BA%E5%88%B6
 */
public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
/*
before method send
send message:java
after method send
JDK9+时，需要add VM options：
--add-opens java.base/java.lang=ALL-UNNAMED
 */