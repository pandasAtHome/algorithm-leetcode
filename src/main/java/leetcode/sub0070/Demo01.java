package leetcode.sub0070;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
            // 1、定义一个列表，记录每种数量的阶梯的攀登方式数量
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            // 2、记录每种阶梯的结果
            /* +++++ 时间 O(n) +++++ */
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
