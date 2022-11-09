package leetcode.dynamic_programming.sub0646;

import utils.ArrayUtil;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] pairs;
        pairs = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        };
        System.out.println(solution.findLongestChain(pairs) + " = 2");
        pairs = new int[][]{
                {-6,9},
                {1,6},
                {8,10},
                {-1,4},
                {-6,-2},
                {-9,8},
                {-5,3},
                {0,3}
        };
        System.out.println(solution.findLongestChain(pairs) + " = 3");
    }

    class Solution {
        public int findLongestChain(int[][] pairs) {
            // 1、按第一位数字进行排序
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
            int n = pairs.length;
            // 2、定义一个数组：`dp[i]` 表示 `pairs[0:i]` 的最大数对链
            /* ----- 空间 O(n) ----- */
            int[] dp = new int[n];
            // 3、遍历每个数对，按条件连接
            /* +++++ 时间 O(n^2) +++++ */
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
