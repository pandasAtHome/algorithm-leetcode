package leetcode.data_structure.sub0048;

import utils.ArrayUtil;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] matrix;
        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix);
        System.out.println("[[7,4,1],[8,5,2],[9,6,3]]");
        ArrayUtil.showArray(matrix);

        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix);
        System.out.println("[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
        ArrayUtil.showArray(matrix);

        matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        solution.rotate(matrix);
        System.out.println("[[21, 16, 11, 6, 1],[22, 17, 12, 7, 2],[23, 18, 13, 9, 3],[24, 19, 14, 9, 4],[25, 20, 15, 10, 5]]");
        ArrayUtil.showArray(matrix);
    }

    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            /* ----- 空间 O(1) ----- */
            int temp, stopRow = n / 2, stopCol;
            // 1、从外层向内层，按 `回字形` 对值进行原地交换
            /* +++++ 时间 O(n ^ 2) +++++ */
            for (int i = 0; i < stopRow; i++) {
                stopCol = n - i - 1;
                for (int j = i; j < stopCol; j++) {
                    temp = matrix[i][j];
                    // 左上角
                    matrix[i][j] = matrix[n - 1 - j][i];
                    // 左下角
                    matrix[n - 1 - j][i] = matrix[stopCol][n - 1 - j];
                    // 右下角
                    matrix[stopCol][n - 1 - j] = matrix[j][stopCol];
                    // 右上角
                    matrix[j][stopCol] = temp;
                }
            }
        }
    }
}
