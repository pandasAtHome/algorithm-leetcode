package leetcode.bitwise_operation.sub0268;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}) + " = 2");
        System.out.println(solution.missingNumber(new int[]{0, 1}) + " = 2");
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) + " = 8");
        System.out.println(solution.missingNumber(new int[]{0}) + " = 1");
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            // 1、转换思路：
            //  `找出 nums 中缺少的数字 x`
            //  =>
            //  `生成一个 [0,n] 的数组，再与 nums 拼接，找出其中落单的数字`
            /* ----- 空间 O(1) ----- */
            int xor = 0;
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                // 2、细节问题1：由于 `x ^ 0 = x`，所以 实际上只需拼接 `[1, n]`
                // 3、采用 `按位异或` 去除 `两个相同的` 数字
                xor ^= (i + 1) ^ nums[i];
            }
            return xor;
        }
    }
}
