package leetcode.bitwise_operation.sub0338;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(Arrays.toString(solution.countBits(2)) + " = [0,1,1]");
        System.out.println(Arrays.toString(solution.countBits(5)) + " = [0,1,1,2,1,2]");
    }

    class Solution {
        public int[] countBits(int n) {
            /* ----- 空间 O(n) ----- */
            int[] result = new int[n + 1];
            // 细节问题1：0的二进制不存在1，所以从 1 开始
            /* +++++ 时间 O(n) +++++ */
            for (int i = 1; i <= n; i++) {
                /**
                 * 1、判断当前数字的二进制最右边一位是否 为1
                 * 2、数字右移一位，并获取该新数字对应的 1的个数
                 */
                result[i] = (i & 1) + result[i >> 1];
            }
            return result;
        }
    }
}
