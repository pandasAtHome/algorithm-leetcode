package leetcode.dynamic_programming.sub0300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) + " = 4");
        System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}) + " = 4");
        System.out.println(solution.lengthOfLIS(new int[]{7,7,7,7,7,7,7}) + " = 1");
        System.out.println(solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}) + " = 6");
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }
    }
}
