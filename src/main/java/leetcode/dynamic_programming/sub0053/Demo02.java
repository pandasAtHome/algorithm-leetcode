package leetcode.dynamic_programming.sub0053;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + " = 6");
        System.out.println(solution.maxSubArray(new int[]{1}) + " = 1");
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}) + " = 23");
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int maxVal = nums[0];
            int total;
            for (int i = 0; i < n; i++) {
                if (nums[i] < 0) {
                    continue;
                }
                total = nums[i];
                for (int j = i + 1; j < n; j++) {
                    total += nums[j];
                    maxVal = Math.max(total, maxVal);
                }
            }
            return maxVal;
        }
    }
}
