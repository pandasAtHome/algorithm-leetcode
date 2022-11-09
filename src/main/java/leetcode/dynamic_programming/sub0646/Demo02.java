package leetcode.dynamic_programming.sub0646;

import utils.ArrayUtil;

import java.util.Arrays;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            // 1、按第二位数字进行排序
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            /**
             * 2、初始化上一个数对的第二位数字为：最小值
             *  - 对于 (first, second)
             *    - 必有：first < second
             *    - 若 first = Integer.MIN_VALUE
             *    - 则 second = Integer.MIN_VALUE + 1
             *  - 故：使 second = Integer.MIN_VALUE
             *  - 则：数对链的长度至少为 1
             */
            int second = Integer.MIN_VALUE;
            int maxLen = 0;
            // 3、遍历每个数对，寻找最长数对链
            for (int[] pair : pairs) {
                if (pair[0] > second) {
                    second = pair[1];
                    maxLen++;
                }
            }
            return maxLen;
        }
    }
}
