package leetcode.dynamic_programming.sub0714;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2) + " = 8");
        System.out.println(solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3) + " = 6");
    }

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int buy = prices[0] + fee;
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] + fee < buy) {
                    buy = prices[i] + fee;
                } else if (prices[i] > buy) {
                    profit += prices[i] - buy;
                    buy = prices[i];
                }
            }

            return profit;
        }
    }
}
