package leetcode.dynamic_programming.sub0413;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2}) + " = 0");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3}) + " = 1");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}) + " = 3");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9}) + " = 6");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9, 11}) + " = 10");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9, 11, 13}) + " = 15");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9, 10, 11, 13, 15}) + " = 8");
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1}) + " = 0");
    }

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return 0;
            }
            int[] dp = new int[n];
            int[] intervals = new int[n];
            intervals[1] = nums[1] - nums[0];
            for (int i = 2; i < n; i++) {
                intervals[i] = nums[i] - nums[i - 1];
                if (intervals[i] == intervals[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                }
            }

            int sum = 0;
            for (int i = 2; i < n; i++) {
                sum += dp[i];
            }

            return sum;
        }
    }
}
