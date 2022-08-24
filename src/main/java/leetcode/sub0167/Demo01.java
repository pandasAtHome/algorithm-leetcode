package leetcode.sub0167;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)) + " = [1, 2]");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6)) + " = [1, 3]");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1, 0}, -1)) + " = [1, 2]");
    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int left = 0, right = numbers.length - 1;
            int sum;
            /* +++++ 遍历数组：时间 O(n) +++++ */
            while (left < right) {
                /* +++++ 求和：时间 O(n) +++++ */
                sum = numbers[left] + numbers[right];
                /* +++++ 目标值判断：时间 O(n) +++++ */
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
                /* +++++ 目标值判断 和 移动指针：时间 O(2n) +++++ */
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return new int[]{-1, -1};
        }
    }
}
