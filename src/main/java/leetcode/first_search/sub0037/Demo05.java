package leetcode.first_search.sub0037;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo05 {
    public static void main(String[] args) {
        Solution solution = new Demo05().new Solution();
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
        // 矩阵
        char[][] board;
        // 每个数字在每行的位置
        boolean[][] usedRows = new boolean[9][9];
        // 每个数字在每列的位置
        boolean[][] usedCols = new boolean[9][9];
        // 每个数字，在每个 9宫格 的位置
        boolean[][][] usedCells = new boolean[3][3][9];
        // 可以填写多个数字的节点
        List<Node> nodes;
        // nodes 的长度
        int nodesLen;
        // 是否已经填写完毕
        boolean success = false;

        public void solveSudoku(char[][] board) {
            this.board = board;
            // 找出所有的固定数字
            findFixedNodesAndSpaceNodes();
            // 排除只有一个数字的节点
            filterOnlyOne();

            nodesLen = this.nodes.size();
            backtrack(0);
        }

        private void findFixedNodesAndSpaceNodes() {
            nodes = new LinkedList<>();
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
        }

        private void filterOnlyOne() {
            int num, size;
            Node node;
            boolean notExistsOnly = false;
            while (!notExistsOnly) {
                notExistsOnly = true;
                size = nodes.size();
                for (int i = 0; i < size;) {
                    node = nodes.get(i);
                    num = hasMulNumber(node);
                    if (num > -1) {
                        fixedNumberAndChangeStatus(node, num);
                        notExistsOnly = false;
                        nodes.remove(i);
                        size--;
                    } else {
                        i++;
                    }
                }
            }
        }

        private int hasMulNumber(Node node) {
            int num, number = -1, cnt = 0;
            for (num = 0; num < 9; num++) {
                if (exists(node, num)) {
                    continue;
                }
                number = num;
                if (++cnt > 1) {
                    return -1;
                }
            }
            return number;
        }

        private void backtrack(int spaceIndex) {
            if (spaceIndex == nodesLen) {
                success = true;
                return;
            }
            Node node = nodes.get(spaceIndex);
            int num;
            for (num = 0; num < 9 && !success; num++) {
                if (exists(node, num)) {
                    continue;
                }
                fixedNumberAndChangeStatus(node, num);
                backtrack(spaceIndex + 1);
                if (success) {
                    return;
                }
                changeStatus(node, num, false);
            }
        }

        private boolean exists(Node node, int num) {
            return usedRows[node.spaceRow][num]
                    || usedCols[node.spaceCol][num]
                    || usedCells[node.cellRow][node.cellCol][num];
        }

        private void fixedNumberAndChangeStatus(Node node, int num) {
            board[node.spaceRow][node.spaceCol] = (char) (num + '0' + 1);
            changeStatus(node, num, true);
        }

        private void changeStatus(Node node, int num, boolean status) {
            usedRows[node.spaceRow][num] = usedCols[node.spaceCol][num] = usedCells[node.cellRow][node.cellCol][num] = status;
        }

        class Node {
            int spaceRow;
            int spaceCol;
            int cellRow;
            int cellCol;

            Node(int spaceRow, int spaceCol) {
                this.spaceRow = spaceRow;
                this.spaceCol = spaceCol;
                this.cellRow = spaceRow / 3;
                this.cellCol = spaceCol / 3;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "spaceRow=" + spaceRow +
                        ", spaceCol=" + spaceCol +
                        '}';
            }
        }
    }

}
