package leetcode.sub0221;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        char[][] matrix;
        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalSquare(matrix) + " = 4");
        matrix = new char[][]{
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(solution.maximalSquare(matrix) + " = 1");
        matrix = new char[][]{
                {'0'}
        };
        System.out.println(solution.maximalSquare(matrix) + " = 0");
    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int maxSide = 0;

            int[][] dp = new int[rows + 1][cols + 1];
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= cols; col++) {
                    if (matrix[row - 1][col - 1] == '1') {
                        dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                        maxSide = Math.max(maxSide, dp[row][col]);
                    }
                }
            }

            return maxSide * maxSide;
        }
    }
}
