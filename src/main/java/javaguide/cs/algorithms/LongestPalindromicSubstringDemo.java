package javaguide.cs.algorithms;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LongestPalindromicSubstringDemo {
    private int index, len;

    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            palindromeHelper(s, i, i);
            palindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public void palindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";//bb
        LongestPalindromicSubstringDemo lpsd = new LongestPalindromicSubstringDemo();
        System.out.println(lpsd.longestPalindrome(s));//bab
    }
}