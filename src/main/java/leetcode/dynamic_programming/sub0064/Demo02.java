package leetcode.dynamic_programming.sub0064;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            // 1、定义一个列表，用于记录到达当前格子的最短距离
            int[] dp = new int[cols];

            // 2、初始化第一个格子距离为其本身
            dp[0] = grid[0][0];

            // 4、计算【上边界】上的格子距离，由于边界上边没有格子，所以只需累计从左边一个到当前格子的距离
            for (int col = 1; col < cols; col++) {
                dp[col] = dp[col - 1] + grid[0][col];
            }
            // 5、每次只能【向右】或【向下】移动，反向思考，只能从【左】或【上】到达当前格子
            int left;
            // 6、计算到达中间格子的最短距离
            for (int row = 1; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    left = col - 1;
                    if (left < 0) {
                        dp[col] += grid[row][col];
                    } else {
                        // 6.1、到达当前格子的距离 = 当前格子距离 + min(到达左边格子的最短距离, 到达上边格子的最短距离)
                        dp[col] = grid[row][col] + Math.min(dp[col - 1], dp[col]);
                    }
                }
            }
            // 7、返回最右下角的格子（即 最短距离）
            return dp[cols - 1];
        }
    }
}
