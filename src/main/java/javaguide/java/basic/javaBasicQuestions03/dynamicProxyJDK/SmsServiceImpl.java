package javaguide.java.basic.javaBasicQuestions03.dynamicProxyJDK;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

