package leetcode.sub0542;

import utils.ArrayUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Demo03 {

    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        int[][] mat;
        mat = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("== [[0,0,0],[0,1,0],[0,0,0]] ==");
        ArrayUtil.showArray(solution.updateMatrix(mat));
        mat = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println("== [[0,0,0],[0,1,0],[1,2,1]] ==");
        ArrayUtil.showArray(solution.updateMatrix(mat));
    }

    class Solution {
        int[][] result;
        int rows;
        int cols;
        /** 当前节点四周节点的偏移量：(两两组成一个坐标：x & y)
         *        x   y
         *  - 左 -1   0
         *  - 上  0   1
         *  - 右  1   0
         *  - 下  0  -1
         */
        private final int[] direction = {-1, 0, 1, 0, -1};

        public int[][] updateMatrix(int[][] mat) {
            this.rows = mat.length;
            this.cols = mat[0].length;
            result = new int[rows][cols];
            boolean[][] used = new boolean[rows][cols];
            Queue<int[]> queue = new LinkedList<>();

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (mat[row][col] == 0) {
                        queue.add(new int[]{row, col});
                        used[row][col] = true;
                    }
                }
            }
            bfs(used, queue);

            return result;
        }

        private void bfs(boolean[][] used, Queue<int[]> queue) {
            int[] location;
            int nextRow, nextCol;
            while (!queue.isEmpty()) {
                location = queue.poll();
                for (int i = 0; i < 4; i++) {
                    nextRow = location[0] + direction[i + 1];
                    nextCol = location[1] + direction[i];
                    if ((nextRow < 0 || nextRow == rows)
                            || (nextCol < 0 || nextCol == cols)
                            || used[nextRow][nextCol]) {
                        continue;
                    }
                    result[nextRow][nextCol] = result[location[0]][location[1]] + 1;
                    queue.add(new int[]{nextRow, nextCol});
                    used[nextRow][nextCol] = true;
                }
            }
        }
    }
}
