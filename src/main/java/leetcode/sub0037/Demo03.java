package leetcode.sub0037;

import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        char[][] board;
//        board = new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//        solution.solveSudoku(board);
//        for (char[] chars : board) {
//            System.out.println(Arrays.toString(chars));
//        }
        board = new char[][]{
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };
        solution.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    class Solution {
        // 每个数字在每行的位置
        int[][] usedRows = new int[9][9];
        // 每个数字在每列的位置
        int[][] usedCols = new int[9][9];
        // 每个数字，在每个 9宫格 的位置
        int[][][] usedCells = new int[3][3][9];
        List<int[]> spaces;
        int spaceNum;
        boolean success = false;
        Map<Integer, Node> indexToNode;

        public void solveSudoku(char[][] board) {
            spaces = new ArrayList<>();
            int num;
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        // 空格
                        spaces.add(new int[]{row, col});
                    } else {
                        // 已填写的数字
                        num = board[row][col] - '0' - 1;
                        usedRows[row][num] = usedCols[col][num] = usedCells[row / 3][col / 3][num] = 1;
                    }
                }
            }

            indexToNode = new HashMap<>();
            spaceNum = spaces.size();
            backtrack(board, 0);
        }

        private void backtrack(char[][] board, int spaceIndex) {
            if (spaceIndex == spaceNum) {
                success = true;
                return;
            }
            Node node;
            if (!indexToNode.containsKey(spaceIndex)) {
                int[] space = spaces.get(spaceIndex);
                node = new Node(space);
                int num;
                for (num = 0; num < 9; num++) {
                    node.addNum(num);
                }
                indexToNode.put(spaceIndex, node);
            } else {
                node = indexToNode.get(spaceIndex);
            }
            for (Integer num : node.nums) {
                if (isFilled(node, num)) {
                    continue;
                }
                changeStatus(node, num, 2);
                board[node.spaceRow][node.spaceCol] = (char) (num + '0' + 1);
                backtrack(board, spaceIndex + 1);
                if (success) {
                    return;
                }
                changeStatus(node, num, 0);
            }
        }

        private boolean isFilled(Node node, int num) {
            return usedRows[node.spaceRow][num] > 0
                    || usedCols[node.spaceCol][num] > 0
                    || usedCells[node.cellRow][node.cellCol][num] > 0;
        }

        private boolean isFixed(Node node, int num) {
            return usedRows[node.spaceRow][num] == 1
                    || usedCols[node.spaceCol][num] == 1
                    || usedCells[node.cellRow][node.cellCol][num] == 1;
        }

        private void changeStatus(Node node, int num, int status) {
            usedRows[node.spaceRow][num] = usedCols[node.spaceCol][num] = usedCells[node.cellRow][node.cellCol][num] = status;
        }

        class Node {
            int spaceRow;
            int spaceCol;
            int cellRow;
            int cellCol;
            Set<Integer> nums = new HashSet<>();

            Node(int[] space) {
                this.spaceRow = space[0];
                this.spaceCol = space[1];
                this.cellRow = spaceRow / 3;
                this.cellCol = spaceCol / 3;
            }

            public void addNum(int num) {
                if (isFixed(this, num)) {
                    return;
                }
                nums.add(num);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "spaceRow=" + spaceRow +
                        ", spaceCol=" + spaceCol +
                        ", nums=" + nums +
                        '}';
            }
        }
    }

}
