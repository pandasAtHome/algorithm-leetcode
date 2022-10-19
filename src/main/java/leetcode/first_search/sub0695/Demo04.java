package leetcode.first_search.sub0695;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo04 {
    public static void main(String[] args) {
        Solution solution = new Demo04().new Solution();
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

        public int maxAreaOfIsland(int[][] grid) {
            int yMax = grid.length;
            int xMax = yMax > 0 ? grid[0].length : 0;
            int area = 0, localArea;

            int curX, curY, nextX, nextY;
            Deque<Integer> land = new ArrayDeque<>();
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    if (grid[y][x] == 0) {
                        continue;
                    }
                    grid[y][x] = 0;
                    localArea = 1;
                    land.push(x);
                    land.push(y);
                    while (!land.isEmpty()) {
                        curY = land.pop();
                        curX = land.pop();
                        // 统计四周陆地面积
                        for (int i = 0; i < 4; i++) {
                            nextX = curX + direction[i];
                            nextY = curY + direction[i + 1];
                            if (nextX < 0 || nextY < 0 || nextX == xMax || nextY == yMax || grid[nextY][nextX] == 0) {
                                continue;
                            }
                            grid[nextY][nextX] = 0;
                            localArea++;
                            land.push(nextX);
                            land.push(nextY);
                        }
                    }

                    area = Math.max(area, localArea);
                }
            }
            return area;
        }
    }
}
