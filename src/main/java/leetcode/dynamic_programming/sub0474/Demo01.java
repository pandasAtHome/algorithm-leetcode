package leetcode.dynamic_programming.sub0474;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3) + " = 4");
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1) + " = 2");
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int l = strs.length;
            // 1、定义一个数组：记录截止到当前的字符串 可组成的最大子集的长度
            /* ----- 空间 O(mn) ----- */
            int[][] dp = new int[m + 1][n + 1];
            int[] zeroAndOne;
            // 2、遍历所有字符串，计算 可组成的最大子集的长度
            /* +++++ 时间 O(lmn) +++++ */
            for (int i = 0; i < l; i++) {
                // 2.1、计算当前字符串中包含的 `0` 和 `1` 的个数
                /* +++++ 时间 O(s) +++++ */
                zeroAndOne = getZeroAndOne(strs[i]);
                // 2.2、找到符合题意的子集，记录最大的子集
                // 2.3、细节问题1：逆向遍历，压缩空间，减少遍历范围
                for (int j = m; j >= zeroAndOne[0]; j--) {
                    for (int k = n; k >= zeroAndOne[1]; k--) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zeroAndOne[0]][k - zeroAndOne[1]] + 1);
                    }
                }

            }
            return dp[m][n];
        }

        private int[] getZeroAndOne(String s) {
            int[] zeroAndOne = new int[2];
            for (int i = 0; i < s.length(); i++) {
                zeroAndOne[s.charAt(i) - '0']++;
            }
            return zeroAndOne;
        }
    }
}
