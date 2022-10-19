package leetcode.dynamic_programming.sub0279;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.numSquares(12) + " = 3");
        System.out.println(solution.numSquares(13) + " = 2");
    }

    class Solution {
        public int numSquares(int n) {
            // 1、记录 [1, n] 每个数字最少完全平方数的个数
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n + 1];
            // 2、获取每个数字的 最少完全平方数的个数
            /* +++++ 时间 O(n * n的开方) +++++ */
            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
