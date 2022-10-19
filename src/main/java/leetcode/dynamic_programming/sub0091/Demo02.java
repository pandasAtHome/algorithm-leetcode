package leetcode.dynamic_programming.sub0091;

import java.util.Arrays;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            int prev = s.charAt(0) - '0', cur;
            if (prev == 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                cur = s.charAt(i - 1) - '0';
                if ((prev == 0 || prev > 2) && cur == 0) {
                    // 00/30/40/...
                    return 0;
                }
                if (prev == 1 || (prev == 2 && cur < 7)) {
                    // [10, 26]
                    dp[i] = dp[i - 2];
                    if (cur > 0) {
                        dp[i] += dp[i - 1];
                    }
                } else {
                    // [1, 9]
                    dp[i] = dp[i - 1];
                }
                prev = cur;
            }
            System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
}
