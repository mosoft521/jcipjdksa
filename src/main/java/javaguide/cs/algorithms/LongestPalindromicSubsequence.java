package javaguide.cs.algorithms;

/**
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        //这里是反着遍历，即行：从下至上、列：从右至左的遍历。
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;//初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));//4
        System.out.println(longestPalindromeSubseq("cbbd"));//2
    }
}