package leetcode.data_structure.sub0240;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] matrix;
        matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution.searchMatrix(matrix, 5) + " = true");
        System.out.println(solution.searchMatrix(matrix, 20) + " = false");
        matrix = new int[][]{
                {1,2,3,4,5}
        };
        System.out.println(solution.searchMatrix(matrix, 2) + " = true");
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 1、获取矩阵的长和宽
            /* ----- 空间 O(1) ----- */
            int n = matrix.length;
            int m = matrix[0].length;
            int row = 0, col = m - 1;
            // 2、z字寻找目标值（从右往左，从上往下）
            /* +++++ 时间 O(m + n) +++++ */
            while (row < n && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                }
                if (matrix[row][col] > target) {
                    // 2.1、比目标值大，左移
                    --col;
                } else {
                    // 2.2、比目标值小，下移
                    ++row;
                }
            }
            return false;
        }
    }
}
