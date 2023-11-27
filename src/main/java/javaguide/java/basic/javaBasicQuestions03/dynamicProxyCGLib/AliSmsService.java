package javaguide.java.basic.javaBasicQuestions03.dynamicProxyCGLib;

public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}