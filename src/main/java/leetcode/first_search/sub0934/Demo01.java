package leetcode.first_search.sub0934;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] grid;
        grid = new int[][]{
                {0, 1},
                {1, 0}
        };
//        System.out.println(solution.shortestBridge(grid) + " = 1");
        grid = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
//        System.out.println(solution.shortestBridge(grid) + " = 2");
        grid = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(solution.shortestBridge(grid) + " = 1");
    }

    class Solution {
        /** 与当前陆地相邻的陆地所在方位：(两两组成一个坐标：x & y)
         *        x   y
         *  - 右  1   0
         *  - 下  0  -1
         *  - 左 -1   0
         *  - 上  0   1
         */
        int[] direction = new int[]{1, 0, -1, 0, 1};
        // 0 节点所在行
        Deque<Integer> zeroPointRows;
        // 0 节点所有列
        Deque<Integer> zeroPointCols;
        // 当前搜索的矩阵
        int[][] grid;
        // 矩阵的边长
        int n;

        public int shortestBridge(int[][] grid) {
            zeroPointRows = new LinkedList<>();
            zeroPointCols = new LinkedList<>();
            this.grid = grid;
            n = grid.length;
            // 1、搜索第一个岛屿
            /* ----- 空间 O(n^2) ----- */
            /* +++++ 时间 O(n^2) +++++ */
            findZeroPoint();

            // 2、找出到达第二个岛屿的路径
            /* ----- 空间 O(n^2) ----- */
            /* +++++ 时间 O(n^2) +++++ */
            return bfsFindShortestPath();
        }

        private void findZeroPoint() {
            boolean findFirstIsland = false;
            for (int row = 0; row < n; row++) {
                if (findFirstIsland) {
                    break;
                }
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 0) {
                        continue;
                    }
                    // 找到第一个陆地节点(`grid[row][col] = 1`)
                    dfsFindAllLands(row, col);
                    findFirstIsland = true;
                    break;
                }
            }
        }

        private void dfsFindAllLands(int curRow, int curCol) {
            // 标记为已搜索的陆地节点
            grid[curRow][curCol] = 2;
            int nextRow, nextCol;
            for (int i = 0; i < 4; i++) {
                nextCol = curCol + direction[i];
                nextRow = curRow + direction[i + 1];
                // 细节问题1：由于使用 DFS 搜索的前提是：`grid[row][col] == 1`，所以 `剪枝` 可以放在方向搜索上执行
                if ((nextRow < 0 || nextRow >= n)
                        || (nextCol < 0 || nextCol >= n)) {
                    // 剪枝1：超出矩阵范围
                    continue;
                }
                if (grid[nextRow][nextCol] == 2) {
                    // 剪枝2：已搜索过的陆地节点
                    continue;
                }
                if (grid[nextRow][nextCol] == 0) {
                    // 剪枝3：海岸线
                    zeroPointRows.addLast(nextRow);
                    zeroPointCols.addLast(nextCol);
                    continue;
                }
                // 继续搜索当前岛屿的其他陆地节点
                dfsFindAllLands(nextRow, nextCol);
            }
        }

        private int bfsFindShortestPath() {
            int level = 0;
            int zeroPointNum;
            int curRow, curCol;
            int nextRow, nextCol;
            while (!zeroPointRows.isEmpty()) {
                level++;
                // 当前一轮，需要搜索的海洋节点数量
                zeroPointNum = zeroPointRows.size();
                while (zeroPointNum-- > 0) {
                    curRow = zeroPointRows.removeFirst();
                    curCol = zeroPointCols.removeFirst();
                    for (int i = 0; i < 4; i++) {
                        nextCol = curCol + direction[i];
                        nextRow = curRow + direction[i + 1];
                        if ((nextRow < 0 || nextRow >= n)
                                || (nextCol < 0 || nextCol >= n)) {
                            // 超出矩阵范围，无需搜索
                            continue;
                        }
                        if (grid[nextRow][nextCol] >= 2) {
                            // 第一岛屿的节点 or 已搜索过的海洋节点
                            continue;
                        }
                        if (grid[nextRow][nextCol] == 1) {
                            // 找到了下一岛屿，返回搜索次数
                            return level;
                        }
                        // 加入下一轮海洋节点搜索
                        zeroPointRows.addLast(nextRow);
                        zeroPointCols.addLast(nextCol);
                        // 标记为已搜索的海洋节点
                        grid[nextRow][nextCol] = 3;
                    }
                }
            }
            return level;
        }
    }
}
