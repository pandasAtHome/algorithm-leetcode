package leetcode.sub0130;


import java.util.Arrays;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},
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
        int rows;
        int cols;

        public void solve(char[][] board) {
            rows = board.length;
            cols = rows > 0 ? board[0].length : 0;
            // 获取可填写 X 的坐标
            boolean[][] canFills = initCanFills(board);
            for (int row = 1; row < rows - 1; row++) {
                for (int col = 1; col < cols - 1; col++) {
                    if (board[row][col] == 'O') {
                        dfsFillX(board, canFills, row, col);
                    }
                }
            }
        }

        private boolean[][] initCanFills(char[][] board) {
            boolean[][] canFills = new boolean[rows][cols];
            // 初始化：默认除了四个方向的边界不可填
            for (int row = 1; row < rows - 1; row++) {
                for (int col = 1; col < cols - 1; col++) {
                    canFills[row][col] = true;
                }
            }
            // 找出上下边界上的0，以及与之相连的0
            for (int col = 0; col < cols; col++) {
                if (board[0][col] == 'O') {
                    dfsFindCanFill(board, canFills, 0, col);
                }
                if (board[rows - 1][col] == 'O') {
                    dfsFindCanFill(board, canFills, rows - 1, col);
                }
            }
            // 找出左右边界上的0，以及与之相连的0
            for (int row = 0; row < rows; row++) {
                if (board[row][0] == 'O') {
                    dfsFindCanFill(board, canFills, row, 0);
                }
                if (board[row][cols - 1] == 'O') {
                    dfsFindCanFill(board, canFills, row, cols - 1);
                }
            }
            return canFills;
        }

        private void dfsFindCanFill(char[][] board, boolean[][] canFills, int row, int col) {
            int nextRow, nextCol;
            for (int i = 0; i < 4; i++) {
                nextCol = col + direction[i];
                nextRow = row + direction[i + 1];
                if ((nextRow < 0 || nextRow >= rows)
                        || (nextCol < 0 || nextCol >= cols)
                        || board[nextRow][nextCol] == 'X'
                        || !canFills[nextRow][nextCol]) {
                    continue;
                }
                canFills[nextRow][nextCol] = false;
                dfsFindCanFill(board, canFills, nextRow, nextCol);
            }
        }

        private void dfsFillX(char[][] board, boolean[][] canFills, int row, int col) {
            if (!canFills[row][col]) {
                return;
            }
            board[row][col] = 'X';
            int nextRow, nextCol;
            for (int i = 0; i < 4; i++) {
                nextCol = col + direction[i];
                nextRow = row + direction[i + 1];
                if ((nextRow < 0 || nextRow >= rows)
                        || (nextCol < 0 || nextCol >= cols)
                        || board[nextRow][nextCol] == 'X') {
                    continue;
                }
                dfsFillX(board, canFills, nextRow, nextCol);
            }
        }
    }
}
