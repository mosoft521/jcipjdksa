package javaguide.cs.algorithms;

/**
 * https://www.nowcoder.com/test/8246651/summary
 * 爱奇艺 2018 秋招 Java：
 * 一个合法的括号匹配序列有以下定义:
 * <p>
 * 空串""是一个合法的括号匹配序列
 * 如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 * 如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 * 每个合法的括号序列都可以由以上规则生成。
 * 例如: "","()","()()","((()))"都是合法的括号序列
 * 对于一个合法的括号序列我们又有以下定义它的深度:
 * <p>
 * 空串""的深度是 0
 * 如果字符串"X"的深度是 x,字符串"Y"的深度是 y,那么字符串"XY"的深度为 max(x,y)
 * 如果"X"的深度是 x,那么字符串"(X)"的深度是 x+1
 * 例如: "()()()"的深度是 1,"((()))"的深度是 3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0, max = 0, i;
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            max = Math.max(max, cnt);
        }
        sc.close();
        System.out.println(max);
    }
}