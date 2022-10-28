package leetcode.dynamic_programming.sub0650;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.minSteps(10) + " = 7");
        System.out.println(solution.minSteps(9) + " = 6");
        System.out.println(solution.minSteps(8) + " = 6");
        System.out.println(solution.minSteps(5) + " = 5");
        System.out.println(solution.minSteps(3) + " = 3");
        System.out.println(solution.minSteps(1) + " = 0");
    }

    class Solution {
        public int minSteps(int n) {
            // 1、定义一个数组，记录：`[0, n]` 个 `A` 各自至少需要多少次操作
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n + 1];
            // 2、遍历 i 个 A 需要的最少操作次数
            // 3、边界问题1：笔记本上已存在 1个 A，所以从 2 开始寻找
            /* +++++ 时间 O(n * sqrt(n)) +++++ */
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                // 边界问题2：1 能被所有自然数整除，所以从 2 开始
                // 细节问题1：`[2, i的平方根]` 中，不存在 `i % j == 0`，则 `(i的平方根, i]` 也不会存在 `i % j == 0`
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + dp[i / j];
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
