package leetcode.data_structure.sub0870;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println("[2, 11, 7, 15]");
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println("[24, 32, 8, 12]");
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }

    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] result = new int[n];
            // 定义一个队列，记录 nums2 的每个数字及其对应的位置 i
            /* ----- 空间 O(n) ----- */
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new int[]{nums2[i], i});
            }
            // 按 nums2 的数字大小排序
            list.sort((a, b) -> a[0] - b[0]);
            // 按 nums1 的数字大小排序
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(nums1);
            // nums2 的左右指针
            int left = 0, right = n - 1;
            int[] items;
            // 使用田忌赛马的思想进行比较：
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                items = list.get(left);
                if (nums1[i] > items[0]) {
                    // `nums1[i] > nums2[i]`：放左边
                    result[items[1]] = nums1[i];
                    left++;
                } else {
                    // `nums1[i] <= nums2[i]`：放右边
                    items = list.get(right--);
                    result[items[1]] = nums1[i];
                }
            }

            return result;
        }
    }
}
