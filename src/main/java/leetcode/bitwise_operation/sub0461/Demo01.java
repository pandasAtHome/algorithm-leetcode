package leetcode.bitwise_operation.sub0461;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.hammingDistance(1, 4) + " = 2");
        System.out.println(solution.hammingDistance(3, 1) + " = 1");
    }

    class Solution {
        public int hammingDistance(int x, int y) {
            // 1、对两个整数进行 按位异或，标记出位不相同的地方（用 1 表示）
            /* ----- 空间 O(1) ----- */
            int diff = x ^ y;
            int result = 0;
            // 由于最多执行 32 次，所以此处的时间复杂度位 O(1)
            /* +++++ 时间 O(1) +++++ */
            while (diff > 0) {
                // 2、判断当前的最右一位是否为 1
                result += (diff & 1);
                // 3、右移 1 位
                diff = diff >> 1;
            }
            return result;
        }
    }
}
