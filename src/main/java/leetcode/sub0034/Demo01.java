package leetcode.sub0034;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11)) + " = [3, 4]");
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) + " = [3, 4]");
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)) + " = [-1, -1]");
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 3)) + " = [-1, -1]");
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)) + " = [-1, -1]");
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 1、寻找 `开始坐标` = 第一个 `>= target` 的坐标
            int start = binarySearch(nums, target, -1);
            /*
             * - 2、细节问题2：数组中，不存在目标值
             *   - `target < nums[0]`               => `start = 0`  => `target > nums[start]`
             *   - `nums[0] < target < nums[n-1]`   => `start = x`  => `target != nums[start]`
             *   - `nums[n-1] < target`             => `start = n`  => `index 超出范围`
             */
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }
            // 3、寻找 `结束坐标` = 第一个 `> target` 的坐标 - 1
            // 4、找到 `开始坐标` 后，寻找 `结束坐标` 时，可以使用 `开始坐标` 作为 `起始点`
            int end = binarySearch(nums, target, start);

            return new int[]{start, end - 1};
        }

        /**
         * 二分查找，寻找目标值的 开始坐标 & 结束坐标 + 1
         * @param nums      非递减数组
         * @param target    目标值
         * @param start     寻找的起始点
         * @return 坐标
         */
        private int binarySearch(int[] nums, int target, int start) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int left = (start == -1 ? 0 : start), right = nums.length, mid;
            /* +++++ 二分查找：时间 O(log n) +++++ */
            // 边界问题1：退出条件：`low < high`
            while (left < right) {
                /* +++++ 赋值：时间 O(1) +++++ */
                /* +++++ 计算：时间 2 * O(1) +++++ */
                mid = (left + right) / 2;
                /* +++++ 元素查找：时间 O(1) +++++ */
                /* +++++ 比较：时间 O(1) +++++ */
                /* +++++ 赋值：时间 O(1) +++++ */
                if (nums[mid] > target || (start == -1 && nums[mid] == target)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            // 1、细节问题1：空数组
            if (n == 0) {
                return new int[]{-1, -1};
            }
            // 2、寻找 `开始坐标` = 第一个 `>= target` 的坐标
            int low = 0, high = n - 1, mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            /*
             * - 3、细节问题2：数组中，不存在目标值
             *   - `target < nums[0]`               => `start = 0`  => `target > nums[start]`
             *   - `nums[0] < target < nums[n-1]`   => `start = x`  => `target != nums[start]`
             *   - `nums[n-1] < target`             => `start = n`  => `index 超出范围`
             */
            if (nums[high] != target) {
                return new int[]{-1, -1};
            }

            int start = high;
            // 3、寻找 `结束坐标` = 第一个 `> target` 的坐标 - 1
            low = start;
            high = n - 1;
            while (low < high) {
                mid = (low + high + 1) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            return new int[]{start, high};
        }
    }

    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            // 1、细节问题1：空数组
            if (n == 0) {
                return new int[]{-1, -1};
            }
            // 2、寻找 `开始坐标` = 第一个 `>= target` 的坐标
            int start = findStartIdx(nums, target);
            System.out.println(start);
            /*
             * - 3、细节问题2：数组中，不存在目标值
             *   - `target < nums[0]`               => `start = 0`  => `target > nums[start]`
             *   - `nums[0] < target < nums[n-1]`   => `start = x`  => `target != nums[start]`
             *   - `nums[n-1] < target`             => `start = n`  => `index 超出范围`
             */
            if (start == n || nums[start] != target) {
                return new int[]{-1, -1};
            }

            // 3、寻找 `结束坐标` = 第一个 `> target` 的坐标 - 1
            return new int[]{start, findEndIdx(nums, target, start)};
        }

        private int findStartIdx(int[] nums, int target) {
            int low = 0, high = nums.length, mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int findEndIdx(int[] nums, int target, int low) {
            int high = nums.length, mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (nums[mid] > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low - 1;
        }
    }

}
