package javaguide.java.basic.javaBasicQuestions03.dynamicProxyJDK;

/**
 * JDK动态代理
 * https://javaguide.cn/java/basis/proxy.html#_3-1-jdk-%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E6%9C%BA%E5%88%B6
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
/*
before method send
send message:java
after method send
 */