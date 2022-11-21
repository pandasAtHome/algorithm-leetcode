package leetcode.dynamic_programming.sub0322;

import utils.ArrayUtil;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11) + " = 3");
        System.out.println(solution.coinChange(new int[]{2}, 3) + " = -1");
        System.out.println(solution.coinChange(new int[]{1}, 0) + " = 0");
    }

    // 阶段二：带有备忘录的递归解法
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] mem = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                mem[i] = -2;
            }
            return helper(mem, coins, amount);
        }

        private int helper(int[] mem, int[] coins, int amount) {
            if (mem[amount] != -2) {
                return mem[amount];
            }
            int res = Integer.MAX_VALUE;
            int temp;
            for (int coin : coins) {
                if (coin > amount) {
                    continue;
                }
                temp = helper(mem, coins, amount - coin);
                if (temp == -1) {
                    continue;
                }
                res = Math.min(res, temp + 1);
            }
            mem[amount] = res == Integer.MAX_VALUE ? -1 : res;
            return mem[amount];
        }
    }
}
