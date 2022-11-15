package leetcode.dynamic_programming.sub0714;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2) + " = 8");
        System.out.println(solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3) + " = 6");
    }

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[] buy = new int[n + 1];
            buy[0] = Integer.MIN_VALUE;
            int[] sell = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i - 1]);
                sell[i] = Math.max(sell[i - 1], buy[i] + prices[i - 1] - fee);
            }
            return sell[n];
        }
    }
}
