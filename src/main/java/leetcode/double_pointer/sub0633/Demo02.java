package leetcode.double_pointer.sub0633;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.judgeSquareSum(5) + " = true");
        System.out.println(solution.judgeSquareSum(3) + " = false");
        System.out.println(solution.judgeSquareSum(7) + " = false");
    }

    // 数学解法：费马平方和定理
    class Solution {
        public boolean judgeSquareSum(int c) {
            for (int base = 2; base * base < c; base++) {
                if (c % base != 0) {
                    continue;
                }
                int exp = 0;
                while (c % base == 0) {
                    c /= base;
                    exp++;
                }
                if (base % 4 != 3 && exp % 2 != 0) {
                    return false;
                }
            }
            return c % 4 != 3;
        }
    }
}
