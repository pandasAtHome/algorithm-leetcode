package leetcode.data_structure.sub0566;

import utils.ArrayUtil;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            int g = 0, h = 0;
            int[][] result = new int[r][c];
            for (int[] ints : mat) {
                for (int j = 0; j < cols; j++) {
                    if (h == c) {
                        g++;
                        h = 0;
                    }
                    result[g][h++] = ints[j];
                }
            }
            return result;
        }
    }
}
