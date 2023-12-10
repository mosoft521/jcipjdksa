package javaguide.cs.algorithms;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 输入:s = "a"
 * 输出:1
 * 输入:s = "aaaaaccc"
 * 输出:7
 */
public class LongestPalindromeDemo {
    public static int longestPalindrome(String s) {
        if (s.length() == 0)
            return 0;
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
//        String s = "a";//1
//        String s = "aaaaaccc";//7
        System.out.println(longestPalindrome(s));//7
    }
}