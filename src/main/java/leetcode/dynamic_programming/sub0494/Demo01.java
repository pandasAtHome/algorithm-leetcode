package leetcode.dynamic_programming.sub0494;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) + " = 5");
        System.out.println(solution.findTargetSumWays(new int[]{1}, 1) + " = 1");
    }

    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // 1、求和，判断 `sum > target` 是否成立
            /* +++++ 时间 O(n) +++++ */
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 2、细节问题1：`sum == target` 只有一种解
            int diff = sum - target;
            if (diff == 0) {
                return 1;
            }
            // 3、边界问题1：`sum < target` ，无解
            // 4、边界问题2：`sum - target` 为基数，无解
            if (sum < target || diff % 2 == 1) {
                return 0;
            }
            /**
             * `neg` : 表示 添加 `-` 号的元素之和
             * `sum - neg` : 表示 添加 `+` 号的元素之和
             * `(sum - neg) - neg = target`
             *   - `neg = (sum - target) / 2`
             */
            int neg = diff / 2;
            // 5、定义一个数组，记录：元素之和 分别等于 `[0, neg]` 的组合个数
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[neg + 1];
            dp[0] = 1;
            /* +++++ 时间 O(n * neg) +++++ */
            for (int num : nums) {
                for (int j = neg; j >= num; j--) {
                    dp[j] += dp[j - num];
                }
            }
            return dp[neg];
        }
    }
}
