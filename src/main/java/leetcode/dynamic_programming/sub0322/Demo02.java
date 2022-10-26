package leetcode.dynamic_programming.sub0322;

import utils.ArrayUtil;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11) + " = 3");
        System.out.println(solution.coinChange(new int[]{2}, 3) + " = -1");
        System.out.println(solution.coinChange(new int[]{1}, 0) + " = 0");
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[amount + 1][n + 1];
            for (int i = 1; i <= amount; i++) {
                dp[i][0] = amount + 1;
            }
            int coin;
            for (int i = 1; i <= amount; i++) {
                for (int j = 1; j <= n; j++) {
                    coin = coins[j - 1];
                    if (i >= coin) {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - coin][j] + 1);
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[amount][n] > amount ? -1 : dp[amount][n];
        }
    }
}
