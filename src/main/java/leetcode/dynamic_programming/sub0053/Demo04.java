package leetcode.dynamic_programming.sub0053;

import java.util.Arrays;

public class Demo04 {
    public static void main(String[] args) {
        Solution solution = new Demo04().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + " = 6");
        System.out.println(solution.maxSubArray(new int[]{1}) + " = 1");
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}) + " = 23");
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int maxVal = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                maxVal = Math.max(maxVal, dp[i]);
            }
            return maxVal;
        }
    }
}
