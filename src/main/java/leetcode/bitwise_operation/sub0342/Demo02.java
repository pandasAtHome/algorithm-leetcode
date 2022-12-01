package leetcode.bitwise_operation.sub0342;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.isPowerOfFour(16) + " = true");
        System.out.println(solution.isPowerOfFour(5) + " = false");
        System.out.println(solution.isPowerOfFour(1) + " = true");
        System.out.println(solution.isPowerOfFour(-2147483648) + " = false");
        System.out.println(solution.isPowerOfFour(-64) + " = false");
    }

    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n < 1) {
                return false;
            }
            while (n > 1) {
                if (n % 4 != 0) {
                    return false;
                }
                n /= 4;
            }
            return n == 1;
        }
    }
}
