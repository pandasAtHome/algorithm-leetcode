package leetcode.first_search.sub0047;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
//        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
//        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
        // [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
        System.out.println(solution.permuteUnique(new int[]{2, 2, 1, 1}));
    }

    class Solution {
        List<List<Integer>> result;
        int n;

        public List<List<Integer>> permuteUnique(int[] nums) {
            result = new ArrayList<>();
            n = nums.length;
            Arrays.sort(nums);
            Map<String, Integer> used = new HashMap<>();
            backtrack(nums, used, 0);
            return result;
        }

        private void backtrack(int[] nums, Map<String, Integer> used, int level) {
            if (level == n) {
                String key = Arrays.toString(nums);
                if (used.containsKey(key)) {
                    return;
                }
                List<Integer> temp = new ArrayList<>();
                for (int num : nums) {
                    temp.add(num);
                }
                used.put(key, 1);
                result.add(temp);
                return;
            }

            for (int i = level; i < n; i++) {
                if (i + 1 < n && nums[i] == nums[i + 1]) {
                    continue;
                }
                swap(nums, i, level);
                backtrack(nums, used, level + 1);
                swap(nums, i, level);
            }
        }

        private void swap(int[] nums, int left, int right) {
            if (left == right) {
                return;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
