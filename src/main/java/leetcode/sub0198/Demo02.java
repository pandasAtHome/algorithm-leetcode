package leetcode.sub0198;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}) + " = 4");
        System.out.println(solution.rob(new int[]{2,7,9,3,1}) + " = 12");
    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            // 1、定义一个列表，记录偷窃到每个房间的最大获利
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n + 1];
            // 偷窃第一个房间的获利
            dp[1] = nums[0];
            // 从 第2个 房间开始计算，记录偷窃到每个房间的最大获利
            /* +++++ 时间 O(n) +++++ */
            for (int i = 2; i <= n; i++) {
                // 2、截止到当前房间，选择 偷窃 or 不偷窃 的最大获利
                dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
            }
            // 3、返回 截止到最后一个房间 偷窃 or 不偷窃 的最大获利
            return Math.max(dp[n - 1], dp[n]);
        }
    }
}
