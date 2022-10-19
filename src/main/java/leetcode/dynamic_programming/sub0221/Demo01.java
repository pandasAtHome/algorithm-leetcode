package leetcode.dynamic_programming.sub0221;

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

            /* ----- 空间 O(nm) ----- */
            int[][] dp = new int[rows + 1][cols + 1];
            // 细节问题1：边长矩阵大小设置为 `原矩阵边长 + 1`，然后从 1 开始遍历，可以避免 `row - 1 < 0` 和 `col - 1 < 0` 判断
            /* +++++ 时间 O(nm) +++++ */
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= cols; col++) {
                    if (matrix[row - 1][col - 1] == '1') {
                        /**
                         * 1、假设 `每个节点` 都是其 `所在正方形` 的 `右下角顶点`，并把 `正方形边长` 记录在 `当前节点` 中
                         * 2、则有：`当前节点` 的边长 大于 其 `左上方相邻` 的3个节点的边长
                         *   - `左 (row-1, col)`、`左上 (row-1, col-1)`、`上 (row, col-1)`
                         */
                        dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                        maxSide = Math.max(maxSide, dp[row][col]);
                    }
                }
            }

            return maxSide * maxSide;
        }
    }
}
