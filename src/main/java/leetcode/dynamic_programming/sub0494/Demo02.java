package leetcode.dynamic_programming.sub0494;

import utils.ArrayUtil;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) + " = 5");
        System.out.println(solution.findTargetSumWays(new int[]{1}, 1) + " = 1");
    }

    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int diff = sum - target;
            if (sum < target || diff % 2 == 1) {
                return 0;
            }
            int neg = diff / 2;
            int n = nums.length;
            int[][] dp = new int[n + 1][neg + 1];
            dp[0][0] = 1;
            int num;
            for (int i = 1; i <= n; i++) {
                num = nums[i - 1];
                for (int j = 0; j <= neg; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= num) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }

            ArrayUtil.showArray(dp);
            return dp[n][neg];
        }
    }
}
