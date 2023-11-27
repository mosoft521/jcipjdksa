package javaguide.java.basic.javaBasicQuestions03.staticProxy;

/**
 * 静态代理
 * https://javaguide.cn/java/basis/proxy.html
 * https://javaguide.cn/java/basis/proxy.html#_2-%E9%9D%99%E6%80%81%E4%BB%A3%E7%90%86
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
/*
before method send()
send message:java
after method send()
 */