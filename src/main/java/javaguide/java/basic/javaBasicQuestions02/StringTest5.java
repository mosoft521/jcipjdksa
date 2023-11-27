package javaguide.java.basic.javaBasicQuestions02;

/**
 * 对比StringTest4
 * 这里有：
 * 常量折叠(Constant Folding)
 */
public class StringTest5 {
    public static void main(String[] args) {
        final String str1 = "str";
        final String str2 = "ing";
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//true
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//true
    }
}
