package leetcode.sub0088;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[] nums1;
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1) + "[1, 2, 2, 3, 5, 6]");

        nums1 = new int[]{1};
        solution.merge(nums1, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums1) + "[1]");

        nums1 = new int[]{0};
        solution.merge(nums1, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1) + "[1]");
    }

    /** 版本1：
     * - 对所有边界问题，提前处理
     * - 使用 2个变量 存储当前比较的元素值
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 1、边界问题：`n == 0`，无需操作
            if (n == 0) {
                // 最好情况：空间 => 无; 时间 => O(1)
                return;
            }
            // 2、边界问题：`m == 0` or `num1的最后一个元素 <= num2的第一个元素`
            if (m == 0 || nums1[m - 1] <= nums2[0]) {
                // 其次情况：空间 => O(1); 时间 => O(n)
                for (int j = 0; j < n; j++) {
                    nums1[m + j] = nums2[j];
                }
                return;
            }

            // 最差情况：空间 => O(1); 时间 O(m + n)
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // 3、获取最大值，从右往左入队
            // 当前可入队的位置
            int pos = m-- + n-- - 1;
            int val1, val2;
            /* +++++ 遍历数组：时间 O(m + n) +++++ */
            while (m >= 0 && n >= 0) {
                /* +++++ 查找 & 赋值：O(2n) +++++ */
                val1 = nums1[m];
                val2 = nums2[n];
                /* +++++ 条件判断 & 赋值 & 2次指针挪动：O(4n) +++++ */
                if (val1 > val2) {
                    // 3.1、左边大，左边入队，移动左指针
                    nums1[pos--] = val1;
                    m--;
                } else if (val1 == val2) {
                    // 3.2、一样大，都入队，左右指针都移动
                    nums1[pos--] = val1;
                    nums1[pos--] = val2;
                    m--;
                    n--;
                } else {
                    // 3.3、右边大，右边入队，移动右指针
                    nums1[pos--] = val2;
                    n--;
                }
            }
            // 4、右边剩余的入队
            /* +++++ 循环 & 赋值 & 2次指针挪动：O(4n) +++++ */
            while (n >= 0) {
                nums1[pos--] = nums2[n--];
            }
        }
    }

    /** 版本2：
     * - 对所有边界问题，提前处理
     */
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 1、边界问题：`n == 0`，无需操作
            if (n == 0) {
                return;
            }
            // 2、边界问题：`m == 0` or `num1的最后一个元素 <= num2的第一个元素`
            if (m == 0 || nums1[m - 1] <= nums2[0]) {
                System.arraycopy(nums2, 0, nums1, m, n);
                return;
            }

            // 3、获取最大值，从右往左入队
            // 当前可入队的位置
            int pos = m-- + n-- - 1;
            while (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[pos--] = nums1[m--];
                } else if (nums1[m] == nums2[n]) {
                    nums1[pos--] = nums1[m--];
                    nums1[pos--] = nums2[n--];
                } else {
                    nums1[pos--] = nums2[n--];
                }
            }
            while (n >= 0) {
                nums1[pos--] = nums2[n--];
            }
        }
    }

    /** 版本2：
     * - 不处理极端情况：`num1[m - 1] == num2[0]`
     */
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 1、获取最大值，从右往左入队
            // 当前可入队的位置
            int pos = m-- + n-- - 1;
            while (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[pos--] = nums1[m--];
                } else if (nums1[m] == nums2[n]) {
                    nums1[pos--] = nums1[m--];
                    nums1[pos--] = nums2[n--];
                } else {
                    nums1[pos--] = nums2[n--];
                }
            }
            while (n >= 0) {
                nums1[pos--] = nums2[n--];
            }
        }
    }
}
