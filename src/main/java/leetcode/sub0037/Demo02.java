package leetcode.sub0037;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
        int spaceNum;
        List<Node> nodes;

        public void solveSudoku(char[][] board) {
            nodes = new ArrayList<>();
            int num;
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        // 空格
                        nodes.add(new Node(row, col));
                    } else {
                        // 已填写的数字
                        num = board[row][col] - '0' - 1;
                        usedRows[row][num] = usedCols[col][num] = usedCells[row / 3][col / 3][num] = true;
                    }
                }
            }

            findSpaceNum(board);

            spaceNum = nodes.size();
            backtrack(board, 0);
        }

        private void findSpaceNum(char[][] board) {
            List<Node> nodes = new ArrayList<>();
            int num;
            for (Node node : this.nodes) {
                for (num = 0; num < 9; num++) {
                    node.addNum(num);
                }
                if (node.nums.size() == 1) {
                    num = node.nums.iterator().next();
                    changeStatus(node, num, true);
                    board[node.spaceRow][node.spaceCol] = (char) (num + '0' + 1);
                } else {
                    nodes.add(node);
                }
            }
            this.nodes = nodes;

        }

        private boolean backtrack(char[][] board, int spaceIndex) {
            if (spaceIndex == spaceNum) {
                return true;
            }
            Node node = nodes.get(spaceIndex);
            for (Integer num : node.nums) {
                if (exists(node, num)) {
                    continue;
                }
                changeStatus(node, num, true);
                board[node.spaceRow][node.spaceCol] = (char) (num + '0' + 1);
                if (backtrack(board, spaceIndex + 1)) {
                    return true;
                }
                changeStatus(node, num, false);
            }
            return false;
        }

        private boolean exists(Node node, int num) {
            return usedRows[node.spaceRow][num] || usedCols[node.spaceCol][num] || usedCells[node.cellRow][node.cellCol][num];
        }

        private void changeStatus(Node node, int num, boolean status) {
            usedRows[node.spaceRow][num] = usedCols[node.spaceCol][num] = usedCells[node.cellRow][node.cellCol][num] = status;
        }

        class Node {
            int spaceRow;
            int spaceCol;
            int cellRow;
            int cellCol;
            Set<Integer> nums = new HashSet<>();

            Node(int[] space) {
                this(space[0], space[1]);
            }

            Node(int spaceRow, int spaceCol) {
                this.spaceRow = spaceRow;
                this.spaceCol = spaceCol;
                this.cellRow = spaceRow / 3;
                this.cellCol = spaceCol / 3;
            }

            public void addNum(int num) {
                if (usedRows[spaceRow][num] || usedCols[spaceCol][num] || usedCells[cellRow][cellCol][num]) {
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
