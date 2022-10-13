package leetcode.sub0064;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        int[][] grid;
        grid = new int[][]{
                {1, 3}
        };
        System.out.println(solution.minPathSum(grid) + " = 4");
        grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(grid) + " = 7");
        grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(solution.minPathSum(grid) + " = 12");
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            // 3、计算【左边界上的格子距离，由于边界左边没有格子，所以只需累计从上一个到当前格子的距离
            for (int row = 1; row < rows; row++) {
                grid[row][0] += grid[row - 1][0];
            }
            // 4、计算【上边界】上的格子距离，由于边界上边没有格子，所以只需累计从左边一个到当前格子的距离
            for (int col = 1; col < cols; col++) {
                grid[0][col] += grid[0][col - 1];
            }
            // 5、每次只能【向右】或【向下】移动，反向思考，只能从【左】或【上】到达当前格子
            int left, up;
            // 6、计算到达中间格子的最短距离
            for (int row = 1; row < rows; row++) {
                up = row - 1;
                for (int col = 1; col < cols; col++) {
                    left = col - 1;
                    // 6.1、到达当前格子的距离 = 当前格子距离 + min(到达左边格子的最短距离, 到达上边格子的最短距离)
                    grid[row][col] += Math.min(grid[row][left], grid[up][col]);
                }
            }
            // 7、返回最右下角的格子（即 最短距离）
            return grid[rows - 1][cols - 1];
        }
    }
}
