package leetcode.first_search.sub0079;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        char[][] board;
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "ABCCED") + " = true");
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "SEE") + " = true");
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "ABCB") + " = false");
    }

    class Solution {
        /** 定义与当前陆地相连的节点的坐标：(两两组成一个坐标：x & y)
         *        x   y
         *  - 左 -1   0
         *  - 上  0   1
         *  - 右  1   0
         *  - 下  0  -1
         */
        int[] direction = {-1, 0, 1, 0, -1};
        // 矩阵行数
        int rows;
        // 矩阵列数
        int cols;
        // 单词的每个字符
        char[] charArr;
        // 单词长度
        int wordLen;
        // 字符使用记录矩阵
        boolean[][] used;

        public boolean exist(char[][] board, String word) {
            // 1、获取矩阵大小
            /* ----- 空间 O(1) ----- */
            rows = board.length;
            cols = rows > 0 ? board[0].length : 0;
            // 2、定义一个矩阵，记录字符是否被使用过
            /* ----- 空间 O(mn) ----- */
            used = new boolean[rows][cols];
            // 3、字符串 转 数组，减少查询耗时：O(3) => O(1)
            /* ----- 空间 O(L) ----- */
            charArr = word.toCharArray();
            wordLen = charArr.length;
            // 4、字符匹配，组成单词
            /* +++++ 时间 O(mn * 3^L) +++++ */
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    // 细节问题1：找到符合条件，即可停止
                    /* ----- 空间 O(mn) ----- */
                    if (backtrack(board, x, y, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, int x, int y, int pos) {
            // 前置条件：能进入回溯， x/y/pos 等都在合理范围内
            if (board[y][x] != charArr[pos]) {
                // 4.1、字符不匹配，退出此链路查找
                return false;
            } else if (wordLen - 1 == pos) {
                // 4.2、已经找到所有字符，返回结果
                return true;
            }
            // 5、锁定当前字符
            used[y][x] = true;
            int nextX, nextY;
            // 6、遍历向当前字符的四个方位（左上右下）匹配目标
            for (int i = 0; i < 4; i++) {
                nextX = x + direction[i];
                nextY = y + direction[i + 1];
                if (nextY < 0 || nextY >= rows
                        || nextX < 0 || nextX >= cols
                        || used[nextY][nextX]) {
                    // 6.1、不符合条件：不在矩阵范围内 or 该位置的字符已被使用
                    continue;
                }
                // 6.2、满足前置条件：矩阵范围内 and 字符未被使用
                if (backtrack(board, nextX, nextY, pos + 1)) {
                    // 单词的所有字符匹配成功，返回结果
                    return true;
                }
            }
            // 7、解锁当前字符
            used[y][x] = false;
            // 8、返回结果
            return false;
        }
    }
}
