package leetcode.dynamic_programming.sub0121;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) + " = 5");
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}) + " = 0");
    }

    class Solution {
        public int maxProfit(int[] prices) {
            // 1、定义两个变量，分别记录：历史最低购买价格 & 现在的最大获利
            /* ----- 空间 O(1) ----- */
            // 细节问题1
            int buy = Integer.MAX_VALUE, profit = 0;
            // 2、计算最大获利
            for (int price : prices) {
                // 2.1、记录截止到现在的历史最低价
                buy = Math.min(buy, price);
                // 2.2、计算以当前价格售卖的利润，保留历史最高利润
                profit = Math.max(profit, price - buy);
            }
            return profit;
        }
    }
}
