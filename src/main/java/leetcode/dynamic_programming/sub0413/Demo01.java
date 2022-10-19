package leetcode.dynamic_programming.sub0413;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
            // 1、定义一个列表，记录每种长度的连续等差子序列的个数
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n];
            // 2、细节问题1：组成等差数列，必须要有3个数字，所以从 `i = 2` 开始遍历
            /* +++++ 时间 O(n) +++++ */
            for (int i = 2; i < n; i++) {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
            }

            // 3、细节问题2：dp 记录是从 `i = 2` 开始的，求和时，可以从 `i = 2` 开始
            int sum = 0;
            /* +++++ 时间 O(n) +++++ */
            for (int i = 2; i < n; i++) {
                sum += dp[i];
            }

            // 4、计算 列表之和 返回
            return sum;
        }
    }
}
