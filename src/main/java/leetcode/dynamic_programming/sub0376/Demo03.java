package leetcode.dynamic_programming.sub0376;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}) + " = 6");
        System.out.println(solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}) + " = 7");
        System.out.println(solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) + " = 2");
        System.out.println(solution.wiggleMaxLength(new int[]{3,3,3,2,5}) + " = 3");
    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int up = 1, down = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = Math.max(up, down + 1);
                } else if (nums[i] < nums[i - 1]) {
                    down = Math.max(up + 1, down);
                }
            }
            return Math.max(up, down);
        }
    }
}
