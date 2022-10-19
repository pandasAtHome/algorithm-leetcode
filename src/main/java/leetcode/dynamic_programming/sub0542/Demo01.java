package leetcode.dynamic_programming.sub0542;

import utils.ArrayUtil;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
        System.out.println("== [[0,1,1,0,0],[0,1,1,0,0],[0,1,0,0,1],[1,1,1,1,0],[1,0,0,1,0]] ==");

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
        int rows;
        int cols;

        public int[][] updateMatrix(int[][] mat) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            this.rows = mat.length;
            this.cols = mat[0].length;
            // 1、定义一个矩阵，记录每个节点到 最近一个0 的距离
            /* ----- 空间 O(mn) ----- */
            int[][] result = new int[rows][cols];
            // 2、距离默认值
            int defaultVal = Integer.MAX_VALUE - 1;
            /**
             * 3、搜索方向：左上 => 右下
             *  - 假设左上角存在一个 0节点
             *  - 寻找每个节点 到 其左上方最近一个0 的距离
             */
            /* +++++ 时间 O(mn) +++++ */
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (mat[row][col] == 0) {
                        // 跳过 0节点
                        result[row][col] = 0;
                        continue;
                    }
                    if (col == 0) {
                        // 第1列：设置默认值
                        result[row][col] = defaultVal;
                    } else {
                        // 其它列：与同一行的前一列 比较
                        result[row][col] = Math.min(defaultVal, result[row][col - 1] + 1);
                    }
                    if (row > 0) {
                        // 其它行(第1行除外)：与同一列的前一行 比较
                        result[row][col] = Math.min(result[row][col], result[row - 1][col] + 1);
                    }
                }
            }

            // 最后一行/列 的索引
            int lastRow = rows - 1;
            int lastCol = cols - 1;
            /**
             * 4、搜索方向：右下 => 左上
             *  - 假设右下角存在一个 0节点
             *  - 计算当前节点到 0节点的 最短距离
             *    - min(【`当前节点` 到 `左上方最近一个0节点` 的距离】, 【`当前节点` 到 `右下方最近一个0节点` 的距离】)
             */
            /* +++++ 时间 O(mn) +++++ */
            for (int row = lastRow; row >= 0; row--) {
                for (int col = lastCol; col >= 0; col--) {
                    if (result[row][col] == 0) {
                        // 跳过 0节点
                        continue;
                    }
                    if (col < lastCol) {
                        // 其它列(最后1列除外)：与同一行的后一列 比较
                        result[row][col] = Math.min(result[row][col], result[row][col + 1] + 1);
                    }
                    if (row < lastRow) {
                        // 其它行(最后1行除外)：与同一列的后一行 比较
                        result[row][col] = Math.min(result[row][col], result[row + 1][col] + 1);
                    }
                }
            }

            return result;
        }
    }

}
