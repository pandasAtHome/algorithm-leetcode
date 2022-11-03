package leetcode.dynamic_programming.sub0213;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
                // 边界问题1：没有元素
                return 0;
            } else if (n == 1) {
                // 边界问题2：只有1个元素
                return nums[0];
            } else if (n == 2) {
                // 边界问题3：只有2个元素
                return Math.max(nums[0], nums[1]);
            }
            /**
             * 有 `3个或以上` 元素：
             * - 首尾截取，计算各自的最大值
             *   - 去头：计算 `nums[1:n-1]` 的累计最大值
             *   - 去尾：计算 `nums[0:n-2]` 的累计最大值
             * - 取 两部分的最大值：`max( nums[0:n-2], nums[1:n-1] )`
             */
            /* ----- 空间 O(n) ----- */
            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }

        private int rob(int[] nums, int start, int end) {
            // 细节问题1：只需要使用两个数值变量记录：`盗取 first` or `不盗取 second`
            int first = nums[start];
            int second = Math.max(first, nums[start + 1]);
            int temp;
            // 从第3个开始，计算可盗取的最大现金
            /* +++++ 时间 O(n) +++++ */
            for (int i = start + 2; i <= end; i++) {
                temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }

            return second;
        }
    }
}
