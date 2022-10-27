package leetcode.dynamic_programming.sub0072;

import utils.ArrayUtil;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.minDistance("horse", "ros") + " = 3");
        System.out.println(solution.minDistance("intention", "execution") + " = 5");
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            // 1、定义一个数组，记录：`word1[0:i]` 变为 `word2[0:j]` 所需要的最少步数
            /* ----- 空间 O(mn) ----- */
            int[][] dp = new int[m + 1][n + 1];
            // 2、初始化：假设 `word2` 为空字符串
            /* +++++ 时间 O(m) +++++ */
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            // 3、初始化 假设 `word1` 为空字符串
            /* +++++ 时间 O(n) +++++ */
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            // 4、细节问题1：把 `word2` 转为 char 数组，加快字符查询
            /* ----- 空间 O(n) ----- */
            char[] chars2 = word2.toCharArray();
            char ch1;
            // 5、遍历字符，计算 从 `word1[0:i]` 转为 `word2[0:j]` 所需步数
            /* +++++ 时间 O(mn) +++++ */
            for (int i = 1; i <= m; i++) {
                ch1 = word1.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(
                            // 5.1、`修改` 操作：字符不同 `步数 +1`
                            dp[i - 1][j - 1] + (ch1 == chars2[j - 1] ? 0 : 1),
                            // 5.2、`插入/删除` 操作：`步数 +1`
                            Math.min(dp[i - 1][j], dp[i][j - 1]) + 1
                    );
                }
            }
            return dp[m][n];
        }
    }
}
