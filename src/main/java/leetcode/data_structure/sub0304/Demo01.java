package leetcode.data_structure.sub0304;

public class Demo01 {
    public static void main(String[] args) {
        int[][] matrix;
        matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new Demo01().new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3) + " = 8");
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2) + " = 11");
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4) + " = 12");
    }

    class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            /* ----- 空间 O(mn) ----- */
            sums = new int[rows + 1][cols + 1];
            /* +++++ 时间 O(mn) +++++ */
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    // 累积和 = 上 + 左 - 左上 + 当前值
                    this.sums[r + 1][c + 1] = sums[r][c + 1]
                            + sums[r + 1][c]
                            - sums[r][c]
                            + matrix[r][c];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 矩阵和 = 右下 - 上 - 左 + 左上
            return sums[row2 + 1][col2 + 1]
                    - sums[row1][col2 + 1]
                    - sums[row2 + 1][col1]
                    + sums[row1][col1];
        }
    }
}
