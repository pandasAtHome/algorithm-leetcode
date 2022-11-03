package leetcode.dynamic_programming.sub0309;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}) + " = 3");
        System.out.println(solution.maxProfit(new int[]{1}) + " = 0");
    }

    /**
     *
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // 1、定义一个数组：`buy[i]` 表示 `第 i 天` 持有股票时，当前的最大收益
            /* ----- 空间 O(n) ----- */
            int[] buy = new int[n + 1];
            buy[1] = -prices[0];
            /**
             * 2、定义一个数组：表示不持有股票时，当前的最大利润
             *  - `sell[i - 2]` 表示 冻结期
             *  - `sell[i - 1]` 表示 不是冻结期
             */
            /* ----- 空间 O(n) ----- */
            int[] sell = new int[n + 1];
            // 3、计算最大利润
            /* +++++ 时间 O(n) +++++ */
            for (int i = 2; i <= n; i++) {
                /**
                 * 状态转移：`max(buy[i - 1], sell[i - 2] - prices[i])`
                 *  - 昨天买入(昨天不是冻结期)：`buy[i - 1]`
                 *  - 今天买入(昨天是冻结期)：`sell[i - 2] - prices[i]`
                 */
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
                /**
                 * 状态转移：`max(sell[i - 1], buy[i - 1] + prices[i])`
                 *  - 昨天卖出(今天是冻结期)：`sell[i - 1]`
                 *  - 今天卖出(明天是冻结期)：`buy[i - 1] + prices[i - 1]`
                 */
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
            }
            return sell[n];
        }
    }
}
