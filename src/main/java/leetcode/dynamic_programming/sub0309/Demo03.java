package leetcode.dynamic_programming.sub0309;

import java.util.Arrays;

public class Demo03 {

    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
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
            for (int i = 1; i < n; i++) {
                /**
                 * 当前不持有股票时，最大收益：
                 *  - 今天为冻结期：`sell[i - 1]`
                 *  - 今天为冻结期：`buy[i - 1] + prices[i]`
                 */
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                /**
                 * 当前持有股票时，最大收益：
                 *  - 昨天不是冻结期：`buy[i - 1]`
                 *  - 昨天是冻结期：`sell[i - 2] - prices[i]`
                 */
                buy[i] = Math.max(
                        buy[i - 1],
                        (i > 1 ? sell[i - 2] : 0) - prices[i]
                );
            }
            return sell[n - 1];
        }
    }
}
