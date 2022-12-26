package leetcode.data_structure.sub0240;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            int n = matrix.length;
            int m = matrix[0].length;
            int left = 0, right = m - 1, mid;
            for (int[] nums : matrix) {
                if (nums[m - 1] < target) {
                    continue;
                }
                if (nums[0] > target) {
                    return false;
                }
                if (nums[left] > target) {
                    left = 0;
                }
                while (left < right) {
                    mid = (left + right) / 2;
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        return true;
                    }
                }
                if (nums[left] == target || nums[right] == target) {
                    return true;
                }
            }
            return false;
        }
    }
}
