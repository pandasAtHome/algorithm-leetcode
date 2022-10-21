package leetcode.dynamic_programming.sub0300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) + " = 4");
        System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}) + " = 4");
        System.out.println(solution.lengthOfLIS(new int[]{7,7,7,7,7,7,7}) + " = 1");
        System.out.println(solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}) + " = 6");
        System.out.println(solution.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}) + " = 6");
        System.out.println(solution.lengthOfLIS(new int[]{1,2,-10,-8,-7}) + " = 3");
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            // 1、定义一个数组，记录当前的最长子序列
            int[] dp = new int[n + 1];
            // 2、边界问题1：默认 数组的第一个元素为 最长子序列
            int len = 1;
            dp[len] = nums[0];
            // 3、遍历数组的每个元素，找出最长子序列
            for (int i = 1; i < n; i++) {
                if (dp[len] < nums[i]) {
                    // 3.1、比子序列的最大元素 大，直接插入到队尾， len +1
                    dp[++len] = nums[i];
                } else {
                    // 3.2、比子序列的最大元素 小，替换子序列中，刚好比 nums[i] 小的元素
                    binary(dp, nums[i], len);
                }
            }
            return len;
        }

        private void binary(int[] dp, int target, int right) {
            int mid, pos = 0, left = 1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (target > dp[mid]) {
                    left = mid + 1;
                    // 细节问题1：记录 最接近 target 的位置
                    pos = mid;
                } else {
                    right = mid - 1;
                }
            }
            // 替换为为：pos + 1
            dp[pos + 1] = target;
        }
    }
}
