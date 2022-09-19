package leetcode.sub0417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] heights;
        heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(solution.pacificAtlantic(heights).toString() + " = [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]");
        heights = new int[][]{
                {2, 1},
                {1, 2}
        };
        System.out.println(solution.pacificAtlantic(heights).toString() + " = [[0,0],[0,1],[1,0],[1,1]]");
    }

    class Solution {
        /** 当前节点四周节点的偏移量：(两两组成一个坐标：x & y)
         *        x   y
         *  - 左 -1   0
         *  - 上  0   1
         *  - 右  1   0
         *  - 下  0  -1
         */
        private final int[] direction = {-1, 0, 1, 0, -1};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int yMax = heights.length;
            int xMax = yMax > 0 ? heights[0].length : 0;
            // 1、定义一个坐标盘，记录下所有能流向 `太平洋` 的节点
            /* ----- 空间 O(mn) ----- */
            boolean[][] canReachPacific = new boolean[yMax][xMax];
            // 2、定义一个坐标盘，记录下所有能流向 `大西洋` 的节点
            /* ----- 空间 O(mn) ----- */
            boolean[][] canReachAtlantic = new boolean[yMax][xMax];
            // 3、遍历左右边界的节点
            /* +++++ 时间 O(m) +++++ */
            for (int y = 0; y < yMax; y++) {
                // 3.1、逆向查找：找出能从左边界流入 `太平洋` 的线路
                /* ----- 空间 O(m) ----- */
                dfs(heights, canReachPacific, 0, y);
                // 3.2、逆向查找：找出能从右边界流入 `大西洋` 的线路
                /* ----- 空间 O(m) ----- */
                dfs(heights, canReachAtlantic, xMax - 1, y);
            }
            // 4、遍历上下边界的节点
            /* +++++ 时间 O(n) +++++ */
            for (int x = 0; x < xMax; x++) {
                // 4.1、逆向查找：找出能从上边界流入 `太平洋` 的线路
                /* ----- 空间 O(n) ----- */
                dfs(heights, canReachPacific, x, 0);
                // 4.2、逆向查找：找出能从下边界流入 `大西洋` 的线路
                /* ----- 空间 O(n) ----- */
                dfs(heights, canReachAtlantic, x, yMax - 1);
            }
//            show(canReachPacific);
//            show(canReachAtlantic);
            // 5、找出能同时到达 `太平洋` 和 `大西洋` 的节点
            List<List<Integer>> result = new ArrayList<>();
            /* +++++ 时间 O(mn) +++++ */
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    if (canReachPacific[y][x] && canReachAtlantic[y][x]) {
                        List<Integer> node = new ArrayList<>();
                        node.add(y);
                        node.add(x);
                        result.add(node);
                    }
                }
            }
            return result;
        }

        private void dfs(int[][] heights, boolean[][] canReach, int x, int y) {
            if (canReach[y][x]) {
                return;
            }
            int yMax = heights.length;
            int xMax = yMax > 0 ? heights[0].length : 0;
            // 标记当前节点为水流流经的节点
            canReach[y][x] = true;
            int nextX, nextY;
            for (int i = 0; i < 4; i++) {
                // 四周节点的坐标
                nextX = x + direction[i];
                nextY = y + direction[i + 1];
                /* - 在大陆范围内
                 *      - 0 <= y < yMax
                 *      - 0 <= x < xMax
                 * - 找出当前节点的四周，海拔持平或更高的节点
                 */
                if ((0 <= nextY && nextY < yMax)
                        && (0 <= nextX && nextX < xMax)
                        && (heights[y][x] <= heights[nextY][nextX])
                ) {
                    // 当前节点的四周，有海拔持平或更高的节点，
                    dfs(heights, canReach, nextX, nextY);
                }
            }
        }

        private void show(boolean[][] canReach) {
            System.out.println("================");
            for (boolean[] reach : canReach) {
                System.out.println(Arrays.toString(reach));
            }
        }
    }
}
