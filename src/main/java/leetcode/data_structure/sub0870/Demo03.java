package leetcode.data_structure.sub0870;

import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println("[2, 11, 7, 15]");
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println("[24, 32, 8, 12]");
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }

    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] result = new int[n];
            Integer[] indexes1 = new Integer[n];
            Integer[] indexes2 = new Integer[n];
            for (int i = 0; i < n; i++) {
                indexes1[i] = i;
                indexes2[i] = i;
            }
            Arrays.sort(indexes1, (i, j) -> nums1[i] - nums1[j]);
            Arrays.sort(indexes2, (i, j) -> nums2[i] - nums2[j]);
            int left = 0, right = n - 1;
            int idx1, idx2;
            for (int i = 0; i < n; i++) {
                idx1 = indexes1[i];
                idx2 = indexes2[left];
                if (nums1[idx1] > nums2[idx2]) {
                    result[idx2] = nums1[idx1];
                    left++;
                } else {
                    result[indexes2[right--]] = nums1[idx1];
                }
            }

            return result;
        }
    }
}
