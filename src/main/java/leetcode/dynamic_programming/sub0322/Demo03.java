package leetcode.dynamic_programming.sub0322;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 3));
        System.out.println(solution.coinChange(new int[]{2, 5}, 3));
    }

    // 阶段一：暴力递归解法
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            int temp;
            for (int coin : coins) {
                if (coin > amount) {
                    continue;
                }
                temp = coinChange(coins, amount - coin);
                if (temp == -1) {
                    continue;
                }
                res = Math.min(res, temp + 1);
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
