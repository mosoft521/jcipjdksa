package javaguide.java.newFeatures.java21;

import static java.lang.StringTemplate.RAW;
import static java.util.FormatProcessor.FMT;

/**
 * java: 字符串模板 是预览功能，默认情况下禁用。
 * （请使用 --enable-preview 以启用 字符串模板）
 */
public class StringTemplatesDemoNew {
    public static void main(String[] args) {
        String name = "Lokesh";

        //STR
        String message = STR. "Greetings \{ name }!" ;
        System.out.println(message);//Greetings Lokesh!

        //FMT
        message = FMT. "Greetings %-12s\{ name }!" ;
        System.out.println(message);//Greetings Lokesh      !

        //RAW
        StringTemplate st = RAW. "Greetings \{ name }!" ;
        message = STR.process(st);
        System.out.println(message);//Greetings Lokesh!
    }
}