package leetcode.dynamic_programming.sub0053;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + " = 6");
        System.out.println(solution.maxSubArray(new int[]{1}) + " = 1");
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}) + " = 23");
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            // 1、定义一个数组，记录：截止到 `nums[i]` 的子序列的最大和
            /* ----- 空间 O(n) ----- */
//            int[] dp = new int[nums.length];
            // 1、细节问题1：状态压缩，`dp[i] = max(dp[i - 1] + nums[i], nums[i])`
            /* ----- 空间 O(1) ----- */
            int prev = 0;
            // 2、定义一个变量，记录：当前所有子序列中的最大和
            int maxVal = Integer.MIN_VALUE;
            // 3、遍历元素，求最大和
            /* +++++ 时间 O(n) +++++ */
            for (int num : nums) {
                prev = Math.max(prev + num, num);
                maxVal = Math.max(maxVal, prev);
            }
            return maxVal;
        }
    }
}
