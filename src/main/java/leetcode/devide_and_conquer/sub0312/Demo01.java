package leetcode.devide_and_conquer.sub0312;

import utils.ArrayUtil;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
//        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}) + " = 167");
        System.out.println(solution.maxCoins(new int[]{9,76,64,21,97,60}) + " = 167");
//        System.out.println(solution.maxCoins(new int[]{1, 5}) + " = 10");
        /**
         * [3, 1, 5, 8] [3, 5, 8]   [3, 8]      [8]
         * 3 1 5 = 15   3 5 8 = 120 1 3 8 = 24  1 8 1 = 8   167
         */
    }

    class Solution {

        public int maxCoins(int[] nums) {
            int n = nums.length;
            /**
             * 1、定义一个数组 `dp[n + 2][n + 2]`
             *  - `dp[i][j]` : 表示 戳破 `(i, j)` 之间的所有气球可获得的最大硬币数量
             */
            /* ----- 空间 O(n^2) ----- */
            int[][] dp = new int[n + 2][n + 2];
            // 2、在气球两边分别插入两个虚拟气球：`nums[-1] = nums[n] = 1`
            /* ----- 空间 O(n) ----- */
            int[] coins = new int[n + 2];
            coins[0] = coins[n + 1] = 1;
            /* +++++ 时间 O(n) +++++ */
            System.arraycopy(nums, 0, coins, 1, n);
            /**
             * 3、开始戳气球，戳破 `(i, j)` 之间的气球可获得的最大硬币数量：
             *  - 最后戳破 `气球k` 时，可获得的最大硬币数量为：
             *    - `i < k < j`
             *    - `dp[i][k] + (coins[i] * coins[k] * coins[j]) + dp[k][j]`
             *      - `dp[i][k]`：戳破 `(i, k)` 之间的气球可获得的最大硬币数量
             *      - `dp[k][j]`：戳破 `(k, j)` 之间的气球可获得的最大硬币数量
             *      - `coins[i] * coins[k] * coins[j]`：戳破 `气球k` 时可获得的硬币数量
             */
            /* +++++ 时间 O(n^3) +++++ */
            int maxVal, temp;
            // 从下往上
            for (int i = n - 1; i >= 0; i--) {
                // 从左到右
                for (int j = i + 2; j < n + 2; j++) {
                    maxVal = 0;
                    for (int k = i + 1; k < j; k++) {
                        temp = dp[i][k] + (coins[i] * coins[k] * coins[j]) + dp[k][j];
                        if (temp > maxVal) {
                            maxVal = temp;
                        }
                    }
                    dp[i][j] = maxVal;
                }
            }

            return dp[0][n + 1];
        }
    }
}
