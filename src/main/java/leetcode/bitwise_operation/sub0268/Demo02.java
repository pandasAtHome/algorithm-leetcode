package leetcode.bitwise_operation.sub0268;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}) + " = 2");
        System.out.println(solution.missingNumber(new int[]{0, 1}) + " = 2");
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) + " = 8");
        System.out.println(solution.missingNumber(new int[]{0}) + " = 1");
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            // 1、定义一个长度位 n+1 的数组
            int[] result = new int[n + 1];
            // 2、标记出现过的数字，`result[i] = 1`
            for (int i = 0; i < n; i++) {
                result[nums[i]] = 1;
            }
            // 3、找出 `result` 中，没出现过的数字(`result[i] == 0`)
            for (int i = 0; i <= n; i++) {
                if (result[i] == 0) {
                    return i;
                }
            }
            return 0;
        }
    }
}
