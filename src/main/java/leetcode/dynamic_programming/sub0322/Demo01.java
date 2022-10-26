package leetcode.dynamic_programming.sub0322;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11) + " = 3");
        System.out.println(solution.coinChange(new int[]{2}, 3) + " = -1");
        System.out.println(solution.coinChange(new int[]{1}, 0) + " = 0");
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 1、定义一个数组：记录组成 `[1, amount]` 金额所需要的最少的硬币数量
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[amount + 1];
            // 2、初始化：最多需要 `amount + 1` 个硬币
            /* +++++ 时间 O(n) +++++ */
            // 3、细节问题1：`dp[0] == 0`：组成 `金额为0` 需要0个硬币
            for (int i = 1; i <= amount; i++) {
                dp[i] = amount + 1;
            }
            // 3、遍历 `[1, amount]` 金额所需要的最少的硬币数量
            /* +++++ 时间 O(mn) +++++ */
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    // 边界问题2：只比较 `硬币面值` 小于等于 `当前总金额` 的硬币
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            /**
             * 4、组成 金额为 `amount` 的硬币数量为：
             *  - 大于 amount 个：无组合
             *  - 否则，返回硬币数量
             */
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
