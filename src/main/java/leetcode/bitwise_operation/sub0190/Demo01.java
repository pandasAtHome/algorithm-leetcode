package leetcode.bitwise_operation.sub0190;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.reverseBits(43261596) + " = 964176192");
//        System.out.println(solution.reverseBits(4294967293L) + " = 3221225471");
    }

    class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            /* ----- 空间 O(1) ----- */
            int result = 0;
            /* +++++ 时间 O(1) +++++ */
            for (int i = 0; i < 32; i++) {
                // 1、向左移动，空出新的位置，用于保存新的位
                result = result << 1;
                // 2、保存 n 的最后一位二进制值（0 or 1）
                result += (n & 1);
                // 3、n 右移，移除已保存的一位二进制值
                n >>>= 1;
            }
            return result;
        }
    }
}
