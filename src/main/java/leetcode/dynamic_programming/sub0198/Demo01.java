package leetcode.dynamic_programming.sub0198;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}) + " = 4");
        System.out.println(solution.rob(new int[]{2,7,9,3,1}) + " = 12");
    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            /**
             * prev1：上一个房间不偷窃时，最大获利；
             * prev2：上一个房间偷窃时，最大获利；
             * cur：当前房间选择【偷窃或不偷窃】的最大获利
             */
            int prev1 = nums[0], prev2 = 0, cur;
            for (int i = 2; i <= n; i++) {
                cur = Math.max(prev1, nums[i - 1] + prev2);
                prev2 = prev1;
                prev1 = cur;
            }
            return Math.max(prev1, prev2);
        }
    }
}
