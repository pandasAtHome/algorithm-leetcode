package leetcode.devide_and_conquer.sub0312;

import utils.ArrayUtil;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}) + " = 167");
        System.out.println(solution.maxCoins(new int[]{1, 5}) + " = 10");
        /**
         * [3, 1, 5, 8] [3, 5, 8]   [3, 8]      [8]
         * 3 1 5 = 15   3 5 8 = 120 1 3 8 = 24  1 8 1 = 8   167
         */
    }

    class Solution {
        private int[] values;
        private int[][] dp;

        public int maxCoins(int[] nums) {
            int n = nums.length;
            this.values = new int[n + 2];
            values[0] = values[n + 1] = 1;
            System.arraycopy(nums, 0, values, 1, n);
            this.dp = new int[n + 2][n + 2];
//            int res = solve(0, n + 1);
//            ArrayUtil.showArray(dp);
//            return res;
            return solve(0, n + 1);
        }

        private int solve(int left, int right) {
            if (left >= right - 1) {
                return 0;
            }
            if (dp[left][right] > 0) {
                return dp[left][right];
            }
            int maxVal = 0, temp;
            for (int i = left + 1; i < right; i++) {
                temp = solve(left, i) + values[left] * values[i] * values[right] + solve(i, right);
                if (maxVal < temp) {
                    maxVal = temp;
                }
            }
            dp[left][right] = maxVal;
            return dp[left][right];
        }
    }
}
