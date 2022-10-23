package leetcode.dynamic_programming.sub1143;

import utils.ArrayUtil;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace") + " = 3");
        System.out.println(solution.longestCommonSubsequence("abccde", "ace") + " = 3");
        System.out.println(solution.longestCommonSubsequence("abcdce", "acec") + " = 3");
        System.out.println(solution.longestCommonSubsequence("abc", "abc") + " = 3");
        System.out.println(solution.longestCommonSubsequence("abc", "def") + " = 0");
    }

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            // 1、定义一个二维数组，dp[i][j] 表示 `text1 的 [0, i) 子串` 与 `text2 的 [0, j) 子串` 的最长公共子串的长度
            /* ----- 空间 O(mn) ----- */
            int[][] dp = new int[m + 1][n + 1];
            // 2、细节问题1：把 待匹配的字符串 转为数组，提高字符查找效率
            /* ----- 空间 O(n) ----- */
            char[] text2Chars = text2.toCharArray();
            char ch1;
            // 3、匹配两个字符串的每个字符，找出最长公共子串的长度
            /* +++++ 时间 O(mn) +++++ */
            for (int i = 1; i <= m; i++) {
                ch1 = text1.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    if (ch1 == text2Chars[j - 1]) {
                        // 3.1、找到相同字符：在 `[0, i - 1)` 和 `[0, j - 1)` 的最长公共子串的长度 + 1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        // 3.2、没找到相同字符：保持当前的最长公共子串的长度
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
