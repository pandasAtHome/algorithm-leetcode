package leetcode.sub0070;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.climbStairs(1) + " = 1");
        System.out.println(solution.climbStairs(2) + " = 2");
        System.out.println(solution.climbStairs(3) + " = 3");
        System.out.println(solution.climbStairs(4) + " = 5");
        System.out.println(solution.climbStairs(5) + " = 8");
    }

    class Solution {
        public int climbStairs(int n) {
            if (n < 4) {
                return n;
            }
            int a = 2, b = 3;
            int temp;
            for (int i = 3; i < n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }
}
