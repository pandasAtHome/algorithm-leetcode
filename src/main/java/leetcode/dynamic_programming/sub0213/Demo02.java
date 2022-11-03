package leetcode.dynamic_programming.sub0213;

import java.util.Arrays;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.rob(new int[]{2, 1, 1, 1, 1, 2}) + " = 4");
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}) + " = 3");
        System.out.println(solution.rob(new int[]{2, 3, 2}) + " = 3");
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}) + " = 4");
        System.out.println(solution.rob(new int[]{1, 2, 3}) + " = 3");
        System.out.println(solution.rob(new int[]{3, 2, 4, 5, 6}) + " = 10");
    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
        }

        private int rob(int[] nums, int start, int end) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[start + 1] = nums[start];
            for (int i = start + 2; i <= end; i++) {
                dp[i] = Math.max(
                        dp[i - 1],
                        nums[i - 1] + dp[i - 2]
                );
            }

            return dp[end];
        }
    }
}
