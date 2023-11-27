package javaguide.java.basic.javaBasicQuestions03.dynamicProxyJDK;

/**
 * 静态代理
 * https://blog.csdn.net/m0_48812293/article/details/128165677
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