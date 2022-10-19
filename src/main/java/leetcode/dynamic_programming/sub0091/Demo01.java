package leetcode.dynamic_programming.sub0091;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.numDecodings("111100116") + " = 0");
        System.out.println(solution.numDecodings("11110116") + " = 9");
        System.out.println(solution.numDecodings("1111011") + " = 6");
        System.out.println(solution.numDecodings("11110") + " = 3");
        System.out.println(solution.numDecodings("12") + " = 2");
        System.out.println(solution.numDecodings("226") + " = 3");
        System.out.println(solution.numDecodings("0") + " = 0");
    }

    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            // 1、定义一个列表，记录到达每个数字时，解码的组合数量
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n + 1];
            // 2、对于 `第一个数字 > 0`，一定会有 1种组合，故 `dp[0] = 1`
            dp[0] = 1;
            // 前一个数字 / 当前的数字
            int prev = 0, cur;
            // 3、遍历每个数字，查看组合方式
            /* +++++ 时间 O(n) +++++ */
            for (int i = 1; i <= n; i++) {
                cur = s.charAt(i - 1) - '0';
                if (cur > 0) {
                    // 3.1、`当前数字 > 0`： 至少保持与前一种数字一样的组合数量
                    dp[i] = dp[i - 1];
                }
                if (i > 1 && prev > 0 && (prev * 10 + cur) < 27) {
                    // 3.2、`9 < 前一数字 * 10 + 当前数字 < 27`： 前两种数字组合数量之和
                    dp[i] += dp[i - 2];
                }
                prev = cur;
            }
            return dp[n];
        }
    }
}
