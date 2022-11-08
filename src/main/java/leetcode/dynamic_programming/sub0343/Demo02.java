package leetcode.dynamic_programming.sub0343;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.integerBreak(2) + " = 1");
        System.out.println(solution.integerBreak(10) + " = 36");
    }

    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            int maxVal;
            for (int i = 2; i <= n; i++) {
                maxVal = 0;
                for (int j = 1; j < i; j++) {
                    maxVal = Math.max(maxVal, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = maxVal;
            }
            return dp[n];
        }
    }
}
