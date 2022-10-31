package leetcode.dynamic_programming.sub0121;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) + " = 5");
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}) + " = 0");
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n + 1];
            int buy = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                buy = Math.min(buy, prices[i]);
                dp[i + 1] = Math.max(dp[i], prices[i] - buy);
            }
            return dp[n];
        }
    }
}
