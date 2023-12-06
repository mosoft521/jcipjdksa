package javaguide.cs.algorithms;

/**
 * 剑指 offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为 We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 */
public class Solution {
    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" ")
     * 遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     */
    public static String replaceSpace(StringBuffer str) {
        int length = str.length();
        // System.out.println("length=" + length);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                result.append("%20");
            } else {
                result.append(b);
            }
        }
        return result.toString();
    }

    /**
     * 第二种方法：利用API替换掉所用空格，一行代码解决问题
     */
    public static String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));//We%20Are%20Happy
        System.out.println(replaceSpace2(str));//We%20Are%20Happy
    }
}