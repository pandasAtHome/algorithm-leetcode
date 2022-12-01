package leetcode.bitwise_operation.sub0136;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}) + " = 1");
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}) + " = 4");
        System.out.println(solution.singleNumber(new int[]{1}) + " = 1");
    }

    class Solution {
        public int singleNumber(int[] nums) {
            // 1、默认第一个数字是唯一数
            /* ----- 空间 O(1) ----- */
            int result = nums[0];
            int n = nums.length;
            /* +++++ 时间 O(n) +++++ */
            for (int i = 1; i < n; i++) {
                // 2、使用 异或原理消除相同的两个数字
                result ^= nums[i];
            }
            return result;
        }
    }
}
