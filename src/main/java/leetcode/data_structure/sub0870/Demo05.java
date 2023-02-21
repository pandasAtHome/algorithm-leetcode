package leetcode.data_structure.sub0870;

import java.util.Arrays;

public class Demo05 {
    public static void main(String[] args) {
        Solution solution = new Demo05().new Solution();
        System.out.println("[2, 11, 7, 15]");
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println("[24, 32, 8, 12]");
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }

    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] result = new int[n];
            Arrays.sort(nums1);
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (used[j]) {
                        continue;
                    }
                    if (nums1[j] > nums2[i]) {
                        used[j] = true;
                        result[i] = nums1[j];
                        break;
                    }
                }
                if (result[i] == 0) {
                    for (int j = 0; j < n; j++) {
                        if (used[j]) {
                            continue;
                        }
                        result[i] = nums1[j];
                        used[j] = true;
                        break;
                    }
                }
            }

            return result;
        }
    }
}
