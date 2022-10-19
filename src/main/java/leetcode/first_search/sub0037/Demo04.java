package leetcode.first_search.sub0037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo04 {
    public static void main(String[] args) {
        Solution solution = new Demo04().new Solution();
        char[][] board;
        board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    class Solution {
        // 每个数字在每行的位置
        boolean[][] usedRows = new boolean[9][9];
        // 每个数字在每列的位置
        boolean[][] usedCols = new boolean[9][9];
        // 每个数字，在每个 9宫格 的位置
        boolean[][][] usedCells = new boolean[3][3][9];
        List<int[]> spaces;
        int spaceNum;
        boolean success = false;

        public void solveSudoku(char[][] board) {
            spaces = new ArrayList<>();
            int num;
            // 1、找出所有的数字 & 空格
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        // 空格
                        spaces.add(new int[]{row, col});
                    } else {
                        // 已填写的数字
                        num = board[row][col] - '0' - 1;
                        usedRows[row][num] = usedCols[col][num] = usedCells[row / 3][col / 3][num] = true;
                    }
                }
            }

            spaceNum = spaces.size();
            backtrack(board, 0);
        }

        private void backtrack(char[][] board, int spaceIndex) {
            if (spaceIndex == spaceNum) {
                success = true;
                return;
            }
            int[] space = spaces.get(spaceIndex);
            int spaceRow = space[0], spaceCol = space[1];
            int cellRowIndex = spaceRow / 3, cellColIndex = spaceCol / 3;
            for (int num = 0; num < 9 && !success; num++) {
                if (usedRows[spaceRow][num] || usedCols[spaceCol][num] || usedCells[cellRowIndex][cellColIndex][num]) {
                    continue;
                }
                usedRows[spaceRow][num] = usedCols[spaceCol][num] = usedCells[cellRowIndex][cellColIndex][num] = true;
                board[spaceRow][spaceCol] = (char) (num + '0' + 1);
                backtrack(board, spaceIndex + 1);
                usedRows[spaceRow][num] = usedCols[spaceCol][num] = usedCells[cellRowIndex][cellColIndex][num] = false;
            }
        }
    }

}
