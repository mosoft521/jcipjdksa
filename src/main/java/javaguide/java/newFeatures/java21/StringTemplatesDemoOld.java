package javaguide.java.newFeatures.java21;

import java.text.MessageFormat;

public class StringTemplatesDemoOld {
    public static void main(String[] args) {
        final String name = "Lokesh";
        String message;
        //concatenation
        message = "Greetings " + name + "!";
        System.out.println(message);

        //String.format()
        message = String.format("Greetings %s!", name);    //concatenation
        System.out.println(message);

        //MessageFormat
        message = MessageFormat.format("Greetings {0}!", name);
        System.out.println(message);

        //StringBuilder
        message = new StringBuilder().append("Greetings ").append(name).append("!").toString();
        System.out.println(message);
    }
}
/*
Greetings Lokesh!
Greetings Lokesh!
Greetings Lokesh!
Greetings Lokesh!

Process finished with exit code 0
 */