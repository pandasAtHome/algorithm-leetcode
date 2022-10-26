package leetcode.dynamic_programming.sub0474;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3) + " = 4");
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1) + " = 2");
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int l = strs.length;
            int[][][] dp = new int[l + 1][m + 1][n + 1];
            String s;
            int zeros, ones;
            for (int i = 1; i <= l; i++) {
                s = strs[i - 1];
                zeros = 0;
                ones = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {

                        if (j >= zeros && k >= ones) {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }

            }
            return dp[l][m][n];
        }
    }
}
