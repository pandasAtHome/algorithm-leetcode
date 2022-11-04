package leetcode.dynamic_programming.sub0053;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + " = 6");
        System.out.println(solution.maxSubArray(new int[]{1}) + " = 1");
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}) + " = 23");
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int maxVal = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(
                        nums[i],
                        Math.max(nums[i] + nums[i - 1], nums[i] + dp[i - 1])
                );
                maxVal = Math.max(maxVal, dp[i]);
            }
            return maxVal;
        }
    }
}
