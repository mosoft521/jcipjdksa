package javaguide.cs.algorithms;

/**
 * coding.interview.guide.chapter_5_stringproblem.Problem_05_ConvertStringToInteger
 * 剑指 offer: 将一个字符串转换成一个整数(实现 Integer.valueOf(string)的功能，
 * 但是 string 不符合数字要求时返回 0)，要求不能使用字符串转换整数的库函数。
 * 数值为 0 或者字符串不是一个合法的数值则返回 0。
 */
public class String2IntDemo {
    public static int strToInt(String str) {
        if (str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        // 判断是否存在符号位
        int flag = 0;
        if (chars[0] == '+')
            flag = 1;
        else if (chars[0] == '-')
            flag = 2;
        int start = flag > 0 ? 1 : 0;
        int res = 0;// 保存结果
        for (int i = start; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {// 调用Character.isDigit(char)方法判断是否是数字，是返回True，否则False
                int temp = chars[i] - '0';
                res = res * 10 + temp;
            } else {
                return 0;
            }
        }
        return flag != 2 ? res : -res;
    }

    public static void main(String[] args) {
        String s = "-12312312";
        System.out.println("使用库函数转换：" + Integer.valueOf(s));
        int res = strToInt(s);
        System.out.println("使用自己写的方法转换：" + res);
    }
}