package leetcode.bitwise_operation.sub0260;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1,2,1,3,2,5})) + " = [3, 5]");
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{-1,0})) + " = [-1, 0]");
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{0,1})) + " = [1, 0]");
    }

    class Solution {
        public int[] singleNumber(int[] nums) {
            // 1、按位异或，去除所有出现过两次的数字，
            // 仅留下两个不相同的数字 `x1`, `x2` ：`xorSum = x1 ^ x2`
            /* ----- 空间 O(1) ----- */
            /* +++++ 时间 O(n) +++++ */
            int xorSum = 0;
            for (int num : nums) {
                xorSum ^= num;
            }

            // 细节问题1：`(-2)^31 <= nums[i] <= 2^31`，存在溢出风险
            int rightOne = Integer.MIN_VALUE == xorSum ? xorSum : xorSum & (-xorSum);
            // 2、由于 `x1 != x2`，所以 `xorSum` 的二进制中，一定存在 `为1的位`
            // 求出最右边为1的位：`rightOne = xorSum & (-xorSum)`
            /* +++++ 时间 O(n) +++++ */
            int num1 = 0, num2 = 0;
            for (int num : nums) {
                // 3、分流：
                if ((num & rightOne) == 0) {
                    // 3.1、`(num & rightOne) == 0` 为 `num1`；
                    num1 ^= num;
                } else {
                    // 3.2、`(num & rightOne) == 1` 为 `num2`；
                    num2 ^= num;
                }
            }

            return new int[]{num1, num2};
        }
    }
}
