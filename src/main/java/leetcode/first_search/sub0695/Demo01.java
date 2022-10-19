package leetcode.first_search.sub0695;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
        public int maxAreaOfIsland(int[][] grid) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // 矩阵的大小：x * y
            int yMax = grid.length;
            int xMax = yMax > 0 ? grid[0].length : 0;
            // 最大的岛屿面积
            int areaMax = 0;
            // 1、检索陆地
            /* +++++ 遍历矩阵：时间 O(m * n) +++++ */
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    /* ----- 递归栈消耗：空间 O(1) ----- */
                    // 2、统计岛屿的面积（所有连在一块的陆地）
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
            // 统计陆地：左
            area += dfs(grid, x - 1, y);
            // 统计陆地：上
            area += dfs(grid, x, y + 1);
            // 统计陆地：右
            area += dfs(grid, x + 1, y);
            // 统计陆地：下
            area += dfs(grid, x, y - 1);
            return area;
        }
    }
}
