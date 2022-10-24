package leetcode.dynamic_programming.sub0416;

import utils.ArrayUtil;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.canPartition(new int[]{1,5,11,5}) + " = true");
        System.out.println(solution.canPartition(new int[]{1,5,10,6}) + " = true");
        System.out.println(solution.canPartition(new int[]{1,2,3,5}) + " = false");
    }

    class Solution {
        public boolean canPartition(int[] nums) {
            // 1、对数组求和
            int total = calTotal(nums);
            // 2、细节问题1：总和为 奇数，不可拆分
            if (total % 2 == 1) {
                return false;
            }
            // 3、求出目标值：总和的一半
            int target = total / 2;
            int n = nums.length;
            // 4、定义一个数组，用于记录 子序列之和 是否可以 等于 j
            boolean[] dp = new boolean[target + 1];
            // 边界问题1：空子序列，默认为 true
            dp[0] = true;
            int num;
            // 5、遍历数组，划分子序列
            for (int i = 0; i < n; i++) {
                num = nums[i];
                for (int j = target; j >= num; j--) {
                    dp[j] |= dp[j - num];
                }
                if (dp[target]) {
                    // 细节问题2：已满足目标值，提前结束循环
                    return true;
                }
            }

            return dp[target];
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
