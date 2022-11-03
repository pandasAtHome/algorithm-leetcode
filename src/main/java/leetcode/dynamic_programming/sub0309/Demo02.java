package leetcode.dynamic_programming.sub0309;

import java.util.Arrays;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}) + " = 3");
        System.out.println(solution.maxProfit(new int[]{1}) + " = 0");
    }

    /**
     *
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] buy = new int[n];
            buy[0] = -prices[0];
            int[] sell = new int[n];
            int[] frozen = new int[n];
            for (int i = 1; i < n; i++) {
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                frozen[i] = buy[i - 1] + prices[i];
                sell[i] = Math.max(sell[i - 1], frozen[i - 1]);
            }
            return Math.max(sell[n - 1], frozen[n - 1]);
        }
    }
}
