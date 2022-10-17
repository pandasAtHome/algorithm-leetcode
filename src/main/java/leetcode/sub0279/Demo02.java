package leetcode.sub0279;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.numSquares(12) + " = 3");
        System.out.println(solution.numSquares(13) + " = 2");
    }

    /**
     * 四平方和定理：任一正整数都可以被表示为最多4个正整数的平方之和
     *  - 完全平方数的个数
     *    - 1: n = a * a
     *    - 2: n = a * a + b * b
     *    - 3: n > 4 ^ k * (8 * m + 7)
     *    - 4: n = 4 ^ k * (8 * m + 7)
     */
    class Solution {
        public int numSquares(int n) {
            if (isPerfectSqrt(n)) {
                return 1;
            }

            if (isFourSquares(n)) {
                return 4;
            }

            for (int i = 1; i * i <= n; i++) {
                if (isPerfectSqrt(n - i * i)) {
                    return 2;
                }
            }

            return 3;
        }

        private boolean isPerfectSqrt(int n) {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        }

        private boolean isFourSquares(int n) {
            while (n % 4 == 0) {
                n /= 4;
            }
            return n % 8 == 7;
        }
    }
}
