package leetcode.first_search.sub0037;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
            // L：待处理节点数量(nodesLen)
            /* ----- 空间 O(L) ----- */
            this.nodes = new ArrayList<>();
            // 1、找出所有的固定数字
            /* +++++ 时间 O(n^2) +++++ */
            findFixedNodes();
            // 2、细节问题1：找出可以填写多个数字的节点
            /* +++++ 时间 O(n^2) +++++ */
            findMulNumNodes();
            // 3、回溯
            /* ----- 空间 O(n * L) ----- */
            /* +++++ 时间 O(n * L) +++++ */
            backtrack(0);
        }

        // 找出所有已知的固定数字（题目给出的）
        private void findFixedNodes() {
            int num;
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] != '.') {
                        // 已知的数字
                        num = board[row][col] - '0' - 1;
                        /**
                         * 1.1、记录【每行】已填写的数字
                         * 1.2、记录【每列】已填写的数字
                         * 1.3、记录【每个 3x3 格】已填写的数字
                         */
                        usedRows[row][num] = usedCols[col][num] = usedCells[row / 3][col / 3][num] = true;
                    }
                }
            }
        }

        /**
         * 找出可以填写多个数字的节点
         *  - 把只能填写一个数字的节点，加入到固定节点中
         */
        private void findMulNumNodes() {
            int num;
            Node node;
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        node = new Node(row, col);
                        num = findOnlyOne(node);
                        if (num > -1) {
                            // 2.1、只能填一个数字：记录 & 排除
                            fixedNumberAndChangeStatus(node, num);
                        } else {
                            // 2.2、可以填多个数字：加入待处理队列
                            nodes.add(node);
                        }
                    }
                }
            }
            // 剩余的空节点数量（即：可以填写多个数字的节点数量）
            nodesLen = nodes.size();
        }

        // 找出只能填写一个数字的节点，并返回所填写的数字
        private int findOnlyOne(Node node) {
            int number = -1;
            for (int i = 0; i < 9; i++) {
                if (exists(node, i)) {
                    continue;
                }
                if (number > -1) {
                    // 已记录可填写的数字，退出搜索
                    return -1;
                }
                number = i;
            }
            return number;
        }

        private void backtrack(int spaceIndex) {
            if (spaceIndex == nodesLen) {
                // 3.1、已填写完毕，退出
                success = true;
                return;
            }
            Node node = nodes.get(spaceIndex);
            for (int num = 0; num < 9 && !success; num++) {
                // 3.2、排除已填写的数字
                if (exists(node, num)) {
                    continue;
                }
                // 3.3、试探填写：固定数字 & 更新状态
                fixedNumberAndChangeStatus(node, num);
                // 3.4、填写一下空格
                backtrack(spaceIndex + 1);
                if (success) {
                    return;
                }
                /**
                 * 3.5、回溯
                 * 假设一定会找到结果，故：
                 *  - 只需把状态复原即可
                 *  - 已填写的数字，不用复原为 '.'
                 */
                changeStatus(node, num, false);
            }
        }

        // 数字是否已存在
        private boolean exists(Node node, int num) {
            return usedRows[node.spaceRow][num]
                    || usedCols[node.spaceCol][num]
                    || usedCells[node.cellRow][node.cellCol][num];
        }

        // 固定数字 & 更新状态
        private void fixedNumberAndChangeStatus(Node node, int num) {
            board[node.spaceRow][node.spaceCol] = (char) (num + '0' + 1);
            changeStatus(node, num, true);
        }

        // 更新状态
        private void changeStatus(Node node, int num, boolean status) {
            usedRows[node.spaceRow][num]
                    = usedCols[node.spaceCol][num]
                    = usedCells[node.cellRow][node.cellCol][num]
                    = status;
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
