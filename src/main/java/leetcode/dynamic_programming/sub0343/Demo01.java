package leetcode.dynamic_programming.sub0343;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.integerBreak(2) + " = 1");
        System.out.println(solution.integerBreak(10) + " = 36");
        System.out.println(solution.integerBreak(20) + " = 1458");
    }

    class Solution {
        public int integerBreak(int n) {
            // 1、边界问题1： 1~2 返回 `n - 1`
            if (n < 3) {
                return n - 1;
            }
            // 2、定义一个数组：记录 `[2, n]` 拆分为整数后的最大乘积
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n + 1];
            /**
             * 数值规律
             * 1~2 : `i - 1`
             * 3~4 : `2 * (i - 2)`
             * 5~6 : `3 * (i - 3)`
             * 7~n : `3 * dp[i - 3]`
             */
            dp[2] = 1;
            // 3、计算每个数字的最大乘积
            /* +++++ 时间 O(n) +++++ */
            for (int i = 3; i <= n; i++) {
                if (i <= 6) {
                    dp[i] = Math.max(2 * (i - 2), 3 * (i - 3));
                } else {
                    dp[i] = 3 * dp[i - 3];
                }
            }
            //  0, 1, 2, 3, 4, 5, 6, 7,  8,  9,  10, 11, 12, 13,  14,  15,  16,  17,  18,  19,  20
            // [0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243, 324, 486, 729, 972, 1458]
//            System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
}
