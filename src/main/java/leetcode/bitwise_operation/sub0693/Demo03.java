package leetcode.bitwise_operation.sub0693;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.hasAlternatingBits(5) + " = true");
        System.out.println(solution.hasAlternatingBits(7) + " = false");
        System.out.println(solution.hasAlternatingBits(8) + " = false");
        System.out.println(solution.hasAlternatingBits(11) + " = false");
    }

    class Solution {
        public boolean hasAlternatingBits(int n) {
            int prev = 2, cur;
            while (n != 0) {
                cur = n & 1;
                if (prev == cur) {
                    return false;
                }
                prev = cur;
                n >>= 1;
            }
            return true;
        }
    }
}
