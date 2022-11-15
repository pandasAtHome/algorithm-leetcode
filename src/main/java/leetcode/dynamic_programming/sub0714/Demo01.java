package leetcode.dynamic_programming.sub0714;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2) + " = 8");
        System.out.println(solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3) + " = 6");
    }

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            /* ----- 空间 O(1) ----- */
            int n = prices.length;
            // 1、买入后，获取的最大利润
            int buy = -prices[0];
            // 2、卖出后，获取的最大利润
            int sell = 0;
            // 3、计算最大利润
            /* +++++ 时间 O(n) +++++ */
            for (int i = 1; i < n; i++) {
                buy = Math.max(buy, sell - prices[i]);
                sell = Math.max(sell, buy + prices[i] - fee);
            }
            return sell;
        }
    }
}
