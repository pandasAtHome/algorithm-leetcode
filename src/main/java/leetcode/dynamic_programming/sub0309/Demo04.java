package leetcode.dynamic_programming.sub0309;

public class Demo04 {

    public static void main(String[] args) {
        Solution solution = new Demo04().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}) + " = 3");
        System.out.println(solution.maxProfit(new int[]{1}) + " = 0");
    }

    /**
     *
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // 1、持有股票时，当前的最大收益
            /* ----- 空间 O(n) ----- */
            int[] buy = new int[n];
            buy[0] = -prices[0];
            // 2、持有股票 且 非冻结期时，若出售，可获取的最大收益
            /* ----- 空间 O(n) ----- */
            int[] sell = new int[n];
            // 3、不持有股票 且 冻结期时，当前的最大收益
            /* ----- 空间 O(n) ----- */
            int[] frozen = new int[n];
            /* +++++ 时间 O(n) +++++ */
            // 4、计算最大利润
            for (int i = 1; i < n; i++) {
                /**
                 * 状态转移：`max(buy[i - 1], frozen[i - 1] - prices[i])`
                 *  - 昨天买入(昨天不是冻结期)：`buy[i - 1]`
                 *  - 今天买入(昨天是冻结期)：`frozen[i - 1] - prices[i]`
                 */
                buy[i] = Math.max(buy[i - 1], frozen[i - 1] - prices[i]);
                /**
                 * 状态转移：`max(sell[i - 1], buy[i - 1] + prices[i])`
                 *  - 昨天卖出(今天是冻结期)：`sell[i - 1]`
                 *  - 今天卖出(明天是冻结期)：`buy[i - 1] + prices[i]`
                 */
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                // 状态转移：
                frozen[i] = sell[i - 1];
            }

            return sell[n - 1];
        }
    }
}
