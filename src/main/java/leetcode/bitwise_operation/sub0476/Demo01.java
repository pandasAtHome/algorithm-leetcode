package leetcode.bitwise_operation.sub0476;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findComplement(5) + " = 2");
        System.out.println(solution.findComplement(1) + " = 0");
        System.out.println(solution.findComplement(2147483647) + " = 0");
//        for (int i = 1; i < 21; i++) {
//            System.out.println(Integer.toBinaryString(i) + " " + solution.findComplement(i));
//        }
    }

    class Solution {
        public int findComplement(int num) {
            // 细节问题1：2 的幂次方，返回 `num - 1`
            if ((num & (num - 1)) == 0) {
                return num - 1;
            }
            // 1、定义一个变量，表示 `2^(i+1)`
            /* ----- 空间 O(1) ----- */
            int highBitNum = 1;
            // 2、找出 `num` 的二进制中最左边为 1 的位（`最高位i`）
            /* +++++ 时间 O(log n) +++++ */
            for (int i = 0; i < 31; i++) {
                if (num < (highBitNum <<= 1)) {
                    break;
                }
            }
            // 3、求 `num` 的位掩码（由 i 个 1 组成的二进制）
            int mask = highBitNum - 1;
            // 4、解码取反（按位异或）
            return num ^ mask;
        }
    }
}
