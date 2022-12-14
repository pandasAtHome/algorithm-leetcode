package leetcode.first_search.sub0130;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        char[][] board;
//        board = new char[][]{
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}
//        };
//        solution.solve(board);
//        for (char[] chars : board) {
//            System.out.println(Arrays.toString(chars));
//        }
//        board = new char[][]{{'X'}};
//        solution.solve(board);
//        for (char[] chars : board) {
//            System.out.println(Arrays.toString(chars));
//        }
        board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        solution.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
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
        // 矩阵行数
        int rows;
        // 矩阵列数
        int cols;

        public void solve(char[][] board) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            rows = board.length;
            cols = rows > 0 ? board[0].length : 0;
            if (rows <= 2 || cols <= 2) {
                // 细节问题1：行数 或 列数 少于 2
                return;
            }
            // 1、筛选出所有不能填写 X 的坐标
            /* ----- 空间 O(2n + 2m) ----- */
            /* +++++ 时间 O(2n + 2m) +++++ */
            findCanNotFill(board);
            // 2、字符替换
            /* +++++ 时间 O(nm) +++++ */
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] == 'A') {
                        // 2.1、不可替换的 'O'：边界上 或 与之相连
                        board[row][col] = 'O';
                    } else if (board[row][col] == 'O') {
                        // 2.2、可替换的 'O'
                        board[row][col] = 'X';
                    }
                }
            }
        }

        private void findCanNotFill(char[][] board) {
            Queue<int[]> queue = new LinkedList<>();
            // 找出上下边界上的 及 与之相连的 o
            for (int col = 0; col < cols; col++) {
                if (board[0][col] == 'O') {
                    queue.add(new int[]{0, col});
                }
                if (board[rows - 1][col] == 'O') {
                    queue.add(new int[]{rows - 1, col});
                }
            }
            // 找出左右边界上的 及 与之相连的 o
            for (int row = 0; row < rows; row++) {
                if (board[row][0] == 'O') {
                    queue.add(new int[]{row, 0});
                }
                if (board[row][cols - 1] == 'O') {
                    queue.add(new int[]{row, cols - 1});
                }
            }

            bfs(board, queue);
        }

        private void bfs(char[][] board, Queue<int[]> queue) {
            int nextCol, nextRow;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                // 细节问题2：在矩阵中，新增一个标识符 `A` 表示不可替换的 `O` ，在替换检测时重新改回 `O`
                board[cell[0]][cell[1]] = 'A';
                for (int i = 0; i < 4; i++) {
                    nextCol = cell[1] + direction[i];
                    nextRow = cell[0] + direction[i + 1];
                    if ((nextRow < 0 || nextRow == rows)
                            || (nextCol < 0 || nextCol == cols)
                            || board[nextRow][nextCol] != 'O') {
                        continue;
                    }
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
