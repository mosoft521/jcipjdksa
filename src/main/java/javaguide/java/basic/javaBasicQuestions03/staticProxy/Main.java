package javaguide.java.basic.javaBasicQuestions03.staticProxy;

/**
 * https://blog.csdn.net/m0_48812293/article/details/128165677
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