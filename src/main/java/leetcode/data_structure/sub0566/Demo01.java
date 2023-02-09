package leetcode.data_structure.sub0566;

import utils.ArrayUtil;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] mat;
        mat = new int[][]{
                {1, 2},
                {3, 4}
        };
        System.out.println("[[1, 2, 3, 4]] -----");
        ArrayUtil.showArray(solution.matrixReshape(mat, 1, 4));
        System.out.println("[[1, 2], [3, 4]] -----");
        ArrayUtil.showArray(solution.matrixReshape(mat, 2, 4));
    }

    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int rows = mat.length;
            int cols = mat[0].length;
            if (r * c != rows * cols) {
                return mat;
            }
            int[][] result = new int[r][c];
            /* +++++ 时间 O(mn) +++++ */
            for (int i = 0; i < rows * cols; i++) {
                result[i / c][i % c] = mat[i / cols][i % cols];
            }
            return result;
        }
    }
}
