package leetcode.dynamic_programming.sub0188;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1}) + " = 2");
        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}) + " = 7");
    }

    class Solution {
        public int maxProfit(int k, int[] prices) {
            // 1、定义一个数组：`buy[j]` 表示 `第j次` 买入时，最大获利
            /* ----- 空间 O(k) ----- */
            int[] buy = new int[k + 1];
            // 2、初始化买入时的获利为最小值
            /* +++++ 时间 O(k) +++++ */
            for (int j = 1; j <= k; j++) {
                buy[j] = Integer.MIN_VALUE;
            }
            // 3、定义一个数组：`sell[j]` 表示 `第j次` 卖出时，最大获利
            /* ----- 空间 O(k) ----- */
            int[] sell = new int[k + 1];

            // 4、遍历股票的所有价格，计算利润
            /* +++++ 时间 O(nk) +++++ */
            for (int price : prices) {
                // 5、更新每次购买的利润
                for (int j = 1; j <= k; j++) {
                    buy[j] = Math.max(buy[j], sell[j - 1] - price);
                    sell[j] = Math.max(sell[j], buy[j] + price);
                }
            }

            return sell[k];
        }
    }
}
