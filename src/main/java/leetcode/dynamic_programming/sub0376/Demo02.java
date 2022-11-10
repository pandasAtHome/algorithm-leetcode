package leetcode.dynamic_programming.sub0376;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}) + " = 6");
        System.out.println(solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}) + " = 7");
        System.out.println(solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) + " = 2");
        System.out.println(solution.wiggleMaxLength(new int[]{3,3,3,2,5}) + " = 3");
    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int[] dp = new int[n];
            int i = 0;
            dp[0] = 1;
            boolean flat = true;
            while (++i < n) {
                dp[i] = dp[i - 1];
                if (nums[i - 1] == nums[i]) {
                    continue;
                }
                flat = nums[i] > nums[i - 1];
                break;
            }
            for (; i < n; i++) {
                dp[i] = dp[i - 1];
                if (nums[i - 1] == nums[i]) {
                    continue;
                }
                if (flat == nums[i - 1] < nums[i]) {
                    dp[i]++;
                    flat = !flat;
                }
            }
            return dp[n - 1];
        }
    }
}
