package leetcode.dynamic_programming.sub0416;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.canPartition(new int[]{1,5,11,5}) + " = true");
        System.out.println(solution.canPartition(new int[]{1,5,10,6}) + " = true");
        System.out.println(solution.canPartition(new int[]{1,2,3,5}) + " = false");
    }

    class Solution {
        public boolean canPartition(int[] nums) {
            int total = calTotal(nums);
            if (total % 2 == 1) {
                return false;
            }
            int target = total / 2;
            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][target + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }

            int num;
            for (int i = 1; i <= n; i++) {
                num = nums[i - 1];
                for (int j = 1; j <= target; j++) {
                    if (j >= num) {
                        dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - num]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n][target];
        }

        private int calTotal(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            return total;
        }
    }
}
