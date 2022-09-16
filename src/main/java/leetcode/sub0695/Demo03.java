package leetcode.sub0695;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        int[][] grid;
        grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(solution.maxAreaOfIsland(grid) + " = 6");
        grid = new int[][]{
                {0,0,0,0,0,0,0,0}
        };
        System.out.println(solution.maxAreaOfIsland(grid) + " = 0");
    }

    class Solution {
        /** 与当前陆地相邻的陆地所在方位：(两两组成一个坐标：x & y)
         *        x   y
         *  - 左 -1   0
         *  - 上  0   1
         *  - 右  1   0
         *  - 下  0  -1
         */
        int[] direction = {-1, 0, 1, 0, -1};
        int xMax;
        int yMax;
        // 下一块陆地的坐标
        int xNext, yNext;
        // 需要统计的陆地节点
        Deque<Land> lands = new ArrayDeque<>();
        // 当前的陆地节点
        Land curLand;

        class Land {
            public int x;
            public int y;

            Land() {
                this(0, 0);
            }

            Land(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int maxAreaOfIsland(int[][] grid) {
            // 矩阵的大小：x * y
            yMax = grid.length;
            xMax = yMax > 0 ? grid[0].length : 0;
            // 当前最大岛屿的面积，当前统计的岛屿的面积
            int areaMax = 0;
            // 1、检索陆地
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    if (grid[y][x] == 0) {
                        // 2、排除 `海洋节点` or `已统计的陆地节点`
                        continue;
                    }
                    // 3、统计岛屿的面积（所有连在一块的陆地）
                    areaMax = Math.max(areaMax, dfs(grid, x, y));
                }
            }
            return areaMax;
        }

        private int dfs(int[][] grid, int x, int y) {
            // 4、去除已统计的陆地（标记为 0）
            grid[y][x] = 0;
            int localArea = 1;
            // 5、统计当前陆地及其四周陆地的总面积
            lands.push(new Land(x, y));
            while (!lands.isEmpty()) {
                curLand = lands.pop();
                // 统计相连陆地的面积
                for (int i = 0; i < 4; i++) {
                    xNext = curLand.x + direction[i];
                    yNext = curLand.y + direction[i + 1];
                    if (xNext < 0 || yNext < 0 || xNext == xMax || yNext == yMax || grid[yNext][xNext] == 0) {
                        // 排除 `矩阵外的节点` 和 `海洋节点 or 已统计的陆地节点`
                        continue;
                    }
                    grid[yNext][xNext] = 0;
                    localArea++;
                    lands.push(new Land(xNext, yNext));
                }
            }
            return localArea;
        }
    }
}
