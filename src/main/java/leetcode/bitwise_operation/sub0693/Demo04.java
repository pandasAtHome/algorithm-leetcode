package leetcode.bitwise_operation.sub0693;

public class Demo04 {
    public static void main(String[] args) {
        Solution solution = new Demo04().new Solution();
        System.out.println(solution.hasAlternatingBits(5) + " = true");
        System.out.println(solution.hasAlternatingBits(7) + " = false");
        System.out.println(solution.hasAlternatingBits(8) + " = false");
        System.out.println(solution.hasAlternatingBits(10) + " = true");
        System.out.println(solution.hasAlternatingBits(11) + " = false");
    }

    class Solution {
        public boolean hasAlternatingBits(int n) {
            return (n & (n >> 1)) == 0;
        }
    }
}
