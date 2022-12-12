package leetcode.bitwise_operation.sub0268;

import java.util.Arrays;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}) + " = 2");
        System.out.println(solution.missingNumber(new int[]{0, 1}) + " = 2");
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) + " = 8");
        System.out.println(solution.missingNumber(new int[]{0}) + " = 1");
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            // 1、对数组进行排序（获得一个递增数组）
            Arrays.sort(nums);
            // 2、遍历 `[0, n]`，找出缺少的数字（i != nums[i]）
            for (int i = 0; i < n; i++) {
                if (i != nums[i]) {
                    return i;
                }
            }
            return n;
        }
    }
}
