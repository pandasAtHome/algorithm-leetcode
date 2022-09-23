package leetcode.sub0051;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.solveNQueens(4) + " = [[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]");
        System.out.println(solution.solveNQueens(1) + " = [[\"Q\"]]");
//        for (int i = 1; i < 10; i++) {
//            System.out.println("n = " + i + ", size = " + solution.solveNQueens(i).size());
//        }
    }

    class Solution {
        List<List<String>> result;
        char[] list;
        int[] queen;
        boolean[] colsUsed;
        boolean[] leftDiagonal;
        boolean[] rightDiagonal;
        public List<List<String>> solveNQueens(int n) {
            // 结果集
            result = new ArrayList<>();
            // 1、初始化每行的位置
            list = new char[n];
            Arrays.fill(list, '.');
            // 2、定义一个列表，记录女皇在每行中，对应的站位（即对应的列）
            queen = new int[n];
            // 3、定义一个列表，记录列的使用
            colsUsed = new boolean[n];
            // 4、定义一个列表，记录当前位置的左斜线上是否放置了女皇（右上-左下）
            leftDiagonal = new boolean[2 * n - 1];
            // 5、定义一个列表，记录当前位置的右斜线上是否放置了女皇（左上-右下）
            rightDiagonal = new boolean[2 * n - 1];
            // 6、回溯，穷举
            backtrace(0, n);
            return result;
        }

        private void backtrace(int row, int n) {
            // 找到了合理的布局，返回结果
            if (row == n) {
                charToList(n);
                return;
            }
            // 左斜对角，右斜对角
            int left, right;
            for (int i = 0; i < n; i++) {
                left = n + (row - i) - 1;
                right = row + i;
                // 1、检查女皇间是否能攻击：同一列 or 左右斜对角
                if (colsUsed[i] || leftDiagonal[left] || rightDiagonal[right]) {
                    /* 剪枝：
                     * 1、当前列已被使用
                     * 2、当前位置的左斜对角，已被使用
                     * 3、当前位置的右斜对角，已被使用
                     */
                    continue;
                }
                // 2、占位：放置女皇（记录女皇在当前行对应的列）
                queen[row] = i;
                // 3、禁用站位（已放置女皇的：列 and 左右斜对角）
                colsUsed[i] = leftDiagonal[left] = rightDiagonal[right] = true;
                // 4、寻找下一个女皇的站位
                backtrace(row + 1, n);
                // 5、解锁站位（已找到正确布局 or 布局不合理）
                colsUsed[i] = leftDiagonal[left] = rightDiagonal[right] = false;
                // 6、取消女皇在当前行的位置
                // （细节问题1：由于已经进行了剪枝，会跳过不合理的情况，所以这一步可以省略）
//                queen[row] = -1;
            }
        }

        // 字符数组转字符串
        private void charToList(int n) {
            List<String> queue = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list[queen[i]] = 'Q';
                queue.add(new String(list));
                list[queen[i]] = '.';
            }
            result.add(queue);
        }
    }
}
