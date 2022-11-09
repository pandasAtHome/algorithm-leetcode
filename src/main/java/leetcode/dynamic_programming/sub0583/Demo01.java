package leetcode.dynamic_programming.sub0583;

import utils.ArrayUtil;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.minDistance("sea", "eat") + " = 2");
        System.out.println(solution.minDistance("leetcode", "etco") + " = 4");
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            // 1、定义一个数组： `dp[i][j]` 表示 `word1[0:i)` 变为 `word2[0:j)` 最少需要多少步
            /* ----- 空间 O(mn) ----- */
            int[][] dp = new int[m + 1][n + 1];
            // 2、边界问题1：`word1` 为空
            /* +++++ 时间 O(n) +++++ */
            for (int col = 1; col <= n; col++) {
                dp[0][col] = col;
            }
            // 3、边界问题2：`word2` 为空
            /* +++++ 时间 O(m) +++++ */
            for (int row = 1; row <= m; row++) {
                dp[row][0] = row;
            }
            // 4、细节问题1：`word2` 变为 字符数组，加快检索
            char[] chars = word2.toCharArray();
            char ch;
            // 5、匹配 `word1` 和 `word2` 的最大公共子串
            /* +++++ 时间 O(mn) +++++ */
            for (int i = 1; i <= m; i++) {
                ch = word1.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    if (ch == chars[j - 1]) {
                        // 5.1、字符相同
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 5.2、字符不同，取最小操作数
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
}
