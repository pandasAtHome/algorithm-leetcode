package leetcode.sub0413;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
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
            /* ----- 定义一堆数值变量：空间 O(1) ----- */
            int sum = 0, cnt = 0, interval = nums[1] - nums[0];
            // 1、细节问题1：组成等差数列，必须要有3个数字，所以从 `i = 2` 开始遍历
            /* +++++ 时间 O(n) +++++ */
            for (int i = 2; i < n; i++) {
                if (nums[i] - nums[i - 1] == interval) {
                    cnt++;
                } else {
                    interval = nums[i] - nums[i - 1];
                    cnt = 0;
                }
                sum += cnt;
            }

            // 2、计算 列表之和 返回
            return sum;
        }
    }
}
