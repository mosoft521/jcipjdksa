package javaguide.java.newFeatures.java12;

public class StringDemo {
    public static void main(String[] args) {
        String text = "Java";
        // 缩进 4 格
        text = text.indent(4);
        System.out.println(text);
        text = text.indent(-10);
        System.out.println(text);
        String result = "foo".transform(input -> input + " bar");
        System.out.println(result); // foo bar
    }
}
/*
    Java

Java


Process finished with exit code 0
 */