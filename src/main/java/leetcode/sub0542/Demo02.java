package leetcode.sub0542;

import utils.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        int[][] mat;
//        mat = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
//        System.out.println("== [[0,0,0],[0,1,0],[0,0,0]] ==");
//        ArrayUtil.showArray(solution.updateMatrix(mat));
//        mat = new int[][]{
//                {0,1,1,0,0},
//                {0,1,1,0,0},
//                {0,1,0,0,1},
//                {1,1,1,1,0},
//                {1,0,0,1,0},
//        };
//        System.out.println("== [[0,1,1,0,0],[0,1,1,0,0],[0,1,0,0,1],[1,1,1,1,0],[1,0,0,1,0]] ==");
//        ArrayUtil.showArray(solution.updateMatrix(mat));
        mat = new int[][]{
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 1, 1}
        };
        System.out.println("== [[2,1,0,1,2,2,2,3,3,2],[2,1,0,1,1,1,1,2,2,1],[3,2,1,1,0,0,0,1,1,0],[2,1,1,2,1,1,0,0,1,0],[1,0,0,1,1,1,0,1,0,1],[0,0,1,0,0,1,1,0,0,1],[0,1,0,1,1,1,1,1,1,1],[1,0,0,1,1,0,0,0,0,0],[0,0,1,1,2,1,0,1,1,1],[1,1,0,0,1,0,1,0,1,2]] ==");
        ArrayUtil.showArray(solution.updateMatrix(mat));
//        mat = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {1, 1, 1}
//        };
//        System.out.println("== [[0,0,0],[0,1,0],[1,2,1]] ==");
//        ArrayUtil.showArray(solution.updateMatrix(mat));
//        mat = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {1, 0, 1},
//                {1, 1, 1},
//                {1, 1, 0},
//        };
//        System.out.println("== [[0,0,0],[0,1,0],[1,2,1]] ==");
//        ArrayUtil.showArray(solution.updateMatrix(mat));
    }

    class Solution {
        int[][] result;
        int rows;
        int cols;

        public int[][] updateMatrix(int[][] mat) {
            this.rows = mat.length;
            this.cols = mat[0].length;
            searchStartFromTopLeft(mat);

            searchStartFromBottomRight();

            return result;
        }

        private void searchStartFromTopLeft(int[][] mat) {
            result = new int[rows][cols];
            int defaultVal = Integer.MAX_VALUE - 1;
            result[0][0] = mat[0][0] == 0 ? 0 : defaultVal;
            for (int col = 1; col < cols; col++) {
                if (mat[0][col] == 0) {
                    result[0][col] = 0;
                } else {
                    result[0][col] = Math.min(defaultVal, result[0][col - 1] + 1);
                }
            }
            for (int row = 1; row < rows; row++) {
                if (mat[row][0] == 0) {
                    result[row][0] = 0;
                } else {
                    result[row][0] = Math.min(defaultVal, result[row - 1][0] + 1);
                }
            }
            for (int row = 1; row < rows; row++) {
                for (int col = 1; col < cols; col++) {
                    if (mat[row][col] == 0) {
                        result[row][col] = 0;
                    } else {
                        result[row][col] = Math.min(
                                Math.min(defaultVal, result[row - 1][col] + 1),
                                result[row][col - 1] + 1
                        );
                    }
                }
            }
        }

        private void searchStartFromBottomRight() {
            // 倒数 1个
            int lastRow = rows - 1;
            int lastCol = cols - 1;
            // 倒数 2个
            int lastButOneRow = lastRow - 1;
            int lastButOneCol = lastCol - 1;
            for (int col = lastButOneCol; col >= 0; col--) {
                if (result[lastRow][col] == 0) {
                    continue;
                }
                result[lastRow][col] = Math.min(result[lastRow][col], result[lastRow][col + 1] + 1);
            }
            for (int row = lastButOneRow; row >= 0; row--) {
                if (result[row][lastCol] == 0) {
                    continue;
                }
                result[row][lastCol] = Math.min(result[row][lastCol], result[row + 1][lastCol] + 1);
            }
            for (int row = lastButOneRow; row >= 0; row--) {
                for (int col = lastButOneCol; col >= 0; col--) {
                    if (result[row][col] == 0) {
                        continue;
                    }
                    result[row][col] = Math.min(
                            Math.min(result[row][col], result[row + 1][col] + 1),
                            result[row][col + 1] + 1
                    );
                }
            }
        }
    }

}
