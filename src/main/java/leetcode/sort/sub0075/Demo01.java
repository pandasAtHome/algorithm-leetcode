package leetcode.sort.sub0075;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[] nums;
        nums = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums) + " = [0,0,1,1,2,2]");
        nums = new int[]{2,0,1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums) + " = [0,1,2]");
    }

    class Solution {
        public void sortColors(int[] nums) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // 1、由于只有3种数字，选取中间的数字为基准值`(pivot = 1)`
            int pivot = 1;
            // 2、定义首尾指针
            int start = 0, end = nums.length - 1;
            // 3、定义 第一个基准值的指针
            int oneIndex = 0;
            // 4、分区：
            /* +++++ 数组遍历：时间 O(n) +++++ */
            while (start <= end) {
                if (nums[start] < pivot) {
                    // 4.1、`curVal < pivot`: 交换 `start` 和 `oneIndex`，并移动 `start` 和 `oneIndex` 指针
                    swap(nums, start++, oneIndex++);
                } else if (nums[start] == pivot) {
                    // 4.2、`curVal == pivot`: 移动 `start` 指针
                    start++;
                } else {
                    // 4.3、`curVal > pivot`: 交换 `end` 和 `oneIndex`，并移动 `end` 指针
                    swap(nums, start, end--);
                }
            }
        }

        private void swap(int[] array, int left, int right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
}
