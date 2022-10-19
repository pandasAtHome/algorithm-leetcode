package leetcode.binary_chop.sub0081;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.search(new int[]{3,3,3,3,3,3,1,2,3,3}, 1) + " = true");
        System.out.println(solution.search(new int[]{3,1}, 1) + " = true");
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 0) + " = true");
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 3) + " = false");
    }

    class Solution {
        public boolean search(int[] nums, int target) {
            int n = nums.length;
            // 1、细节问题1：只有一个元素，直接判断该元素是否为目标值
            if (n == 1) {
                return nums[0] == target;
            }
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // 2、定义首尾指针
            int left = 0, right = nums.length - 1, mid;
            // 中位值
            int midVal;
            // 3、边界问题1：退出条件：left > right
            /* +++++ 二分查找退出条件判断：时间 O(log n) +++++ */
            while (left <= right) {
                /* +++++ 赋值：时间 O(1) +++++ */
                /* +++++ 计算：时间 2 * O(1) +++++ */
                mid = (left + right) / 2;
                // 3.1、找到目标值
                /* +++++ 查找 & 赋值 & 比较：时间 3 * O(1) +++++ */
                if ((midVal = nums[mid]) == target) {
                    return true;
                }
                // 3.2、无法判断左右区间的有序性：left = mid = right
                // 如：{3,3,3,3,3,3,1,2,3,3} , mid = 4
                //             |
                /* +++++ 查找 & 比较：时间 2 * 2 * O(1) +++++ */
                if (nums[left] == midVal && midVal == nums[right]) {
                    // 左右指针都移动一步
                    left++;
                    right--;
                    continue;
                }
                /* +++++ 查找 & 比较：时间 2 * O(1) +++++ */
                if (nums[left] <= midVal) {
                    // 3.3、左区间有序
                    /* +++++ 查找 & 比较：时间 3`` * O(1) +++++ */
                    if (nums[left] <= target && target < midVal) {
                        // 3.3.1、目标在左区间，移动右指针
                        /* +++++ 计算 & 移动指针：时间 2 * O(1) +++++ */
                        right = mid - 1;
                    } else {
                        // 3.3.2、目标在右区间，移动左指针
                        left = mid + 1;
                    }
                } else {
                    // 3.4、右区间有序
                    if (midVal < target && target <= nums[right]) {
                        // 3.4.1、目标在右区间，移动左指针
                        left = mid + 1;
                    } else {
                        // 3.4.2、目标在左区间，移动右指针
                        right = mid - 1;
                    }
                }
            }
            // 4、没找到目标
            return false;
        }
    }
}
