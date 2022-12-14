package leetcode.bitwise_operation.sub0693;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.hasAlternatingBits(5) + " = true");
        System.out.println(solution.hasAlternatingBits(7) + " = false");
        System.out.println(solution.hasAlternatingBits(8) + " = false");
        System.out.println(solution.hasAlternatingBits(11) + " = false");
    }

    class Solution {
        public boolean hasAlternatingBits(int n) {
            int oneOrZero = n & 1;
            while (n != 0) {
                if (oneOrZero != (n & 1)) {
                    return false;
                }
                n >>>= 1;
                oneOrZero = oneOrZero == 0 ? 1 : 0;
            }
            return true;
        }
    }
}
