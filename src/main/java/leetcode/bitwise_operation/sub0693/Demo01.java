package leetcode.bitwise_operation.sub0693;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.hasAlternatingBits(5) + " = true");
        System.out.println(solution.hasAlternatingBits(7) + " = false");
        System.out.println(solution.hasAlternatingBits(8) + " = false");
        System.out.println(solution.hasAlternatingBits(10) + " = true");
        System.out.println(solution.hasAlternatingBits(11) + " = false");
    }

    class Solution {
        public boolean hasAlternatingBits(int n) {
            // 1、假设 n 为 相邻两位不相同的数字
            // 2、`n ^ (n >> 1)` 会得到一个 `左边全是0，右边全是1` 的二进制 (`...0000 1111...`)
            /* ----- 空间 O(1) ----- */
            int zerosOnes = n ^ (n >> 1);
            // 3、`(n ^ (n >> 1)) + 1` 会得到一个 `中间只有一个1，左右两边全是0` 的二进制 (`...0001 0000...`)
            int zerosOneZeros = zerosOnes + 1;
            /* +++++ 时间 O(1) +++++ */
            return (zerosOnes & zerosOneZeros) == 0;
        }
    }
}
