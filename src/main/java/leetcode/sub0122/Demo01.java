package leetcode.sub0122;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) + " = 7");
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}) + " = 4");
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}) + " = 0");
    }

    class Solution {
        public int maxProfit(int[] prices) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int length = prices.length;
            // 1、边界问题：股票只有一天的价格，无利润
            if (length == 1) {
                return 0;
            }
            // 总利润
            int profit = 0;
            // 2、求利润差，所以只需查看到 `n-1` 的股价：`[1, n)`
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 1; i < length; i++) {
                /*
                3、假设每天都买入 or 卖出，求出每天的利润
                  - `利润 > 0`：昨天买入，今天卖出
                  - `利润 <= 0`：昨天买入，昨天卖出
                 */
                /* +++++ 赋值、求最大值：时间 O(n) +++++ */
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }

            return profit;
        }
    }
}
