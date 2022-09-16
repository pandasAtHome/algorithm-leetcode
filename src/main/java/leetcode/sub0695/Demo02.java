package leetcode.sub0695;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
        /** 定义与当前陆地相连的节点的坐标：(两两组成一个坐标：x & y)
         *        x   y
         *  - 左 -1   0
         *  - 上  0   1
         *  - 右  1   0
         *  - 下  0  -1
         */
        int[] direction = {-1, 0, 1, 0, -1};

        public int maxAreaOfIsland(int[][] grid) {
            // 矩阵的大小：x * y
            int yMax = grid.length;
            int xMax = yMax > 0 ? grid[0].length : 0;
            // 最大的岛屿面积
            int areaMax = 0;
            // 1、检索陆地
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    // 2、统计相连的陆地面积
                    areaMax = Math.max(areaMax, dfs(grid, x, y));
                }
            }
            return areaMax;
        }

        private int dfs(int[][] grid, int x, int y) {
            if (x < 0 || y < 0 || y == grid.length || x == grid[y].length || grid[y][x] == 0) {
                // 3、排除 `矩阵外的节点` 和 `海洋节点 or 已统计的陆地节点`
                return 0;
            }
            // 4、去除已统计的陆地（标记为 0）
            grid[y][x] = 0;
            // 5、统计当前陆地及其四周陆地的总面积
            int area = 1;
            for (int i = 0; i < 4; i++) {
                area += dfs(grid, x + direction[i], y + direction[i + 1]);
            }
            return area;
        }
    }
}
