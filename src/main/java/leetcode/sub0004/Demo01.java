package leetcode.sub0004;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
//        System.out.println(solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}) + " = 2.00000");
//        System.out.println(solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}) + " = 2.50000");
        System.out.println(solution.findMedianSortedArrays(new int[]{3,4}, new int[]{1,2,5}) + " = 3.00000");
//        System.out.println(solution.findMedianSortedArrays(new int[]{3,4,4}, new int[]{1,2,5}) + " = 3.50000");
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int totalLen = nums1.length + nums2.length;
            int mid = totalLen / 2;
            // 1、判断数组长度的奇偶性
            if ((totalLen & 1) == 1) {
                /* +++++ 二分查找：时间 O(log (m + n)) +++++ */
                // 2.1、长度为奇数：返回最中间的数值
                return findMedian(nums1, nums2, mid + 1);
            } else {
                /* +++++ 二分查找：时间 2 * O(log (m + n)) +++++ */
                // 2.2、长度为偶数：返回中间两个值的平均值
                return (double) (findMedian(nums1, nums2, mid) + findMedian(nums1, nums2, mid + 1)) / 2;
            }
        }

        private int findMedian(int[] nums1, int[] nums2, int k) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int m = nums1.length;
            int n = nums2.length;
            // 3、为两个数组分别定义指针：`idx1` 和 `idx2`
            int idx1 = 0, idx2 = 0, mid;
            // 移动后，两指针的位置
            int newIdx1, newIdx2;
            /* +++++ 二分查找：时间 O(log (m + n)) +++++ */
            while (true) {
                // 4.1、中位数在 nums2
                /* +++++ 条件判断：时间 O(1) +++++ */
                if (idx1 == m) {
                    return nums2[k - 1 + idx2];
                }
                // 4.2、中位数在 nums1
                /* +++++ 条件判断：时间 O(1) +++++ */
                if (idx2 == n) {
                    return nums1[k - 1 + idx1];
                }
                // 4.3、边界问题1：只剩下一位
                /* +++++ 条件判断：时间 O(1) +++++ */
                if (k == 1) {
                    return Math.min(nums1[idx1], nums2[idx2]);
                }
                // 5.1、假设 两个数组同时移动 一半距离
                /* +++++ 取半计算：时间 O(1) +++++ */
                mid = k / 2;
                /* +++++ 获取移动坐标：时间 2 * O(1) +++++ */
                newIdx1 = Math.min(mid + idx1, m) - 1;
                newIdx2 = Math.min(mid + idx2, n) - 1;
                // 5.2、比较两个新坐标，最终移动较小者
                /* +++++ 数值比较 & 移动指针：时间 3 * O(1) +++++ */
                if (nums1[newIdx1] >= nums2[newIdx2]) {
                    k -= newIdx2 - idx2 + 1;
                    // 5.3、newIdx1 的值较大，移动 idx2
                    idx2 = newIdx2 + 1;
                } else {
                    k -= newIdx1 - idx1 + 1;
                    // 5.4、newIdx2 的值较大，移动 idx1
                    idx1 = newIdx1 + 1;
                }
            }
        }
    }
}
