package leetcode.first_search.sub0047;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
        // [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
        System.out.println(solution.permuteUnique(new int[]{2, 2, 1, 1}));
    }

    class Solution {
        List<List<Integer>> result;
        int n;

        public List<List<Integer>> permuteUnique(int[] nums) {
            result = new ArrayList<>();
            n = nums.length;
            // 1、对序列进行升序排序
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(nums);
            // 2、定义一个列表，记录元素是否被使用
            /* ----- 空间 O(n) ----- */
            boolean[] used = new boolean[n];
            // 3、定义一个栈，用于记录排序的方式
            /* ----- 空间 O(n) ----- */
            Deque<Integer> path = new LinkedList<>();
            // 4、回溯：逐个元素入栈
            /* +++++ 时间 O(n^2) +++++ */
            backtrack(nums, used, path, 0);
            return result;
        }

        private void backtrack(int[] nums, boolean[] used, Deque<Integer> path, int level) {
            if (level == n) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    // 位置已被使用
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    // 前后元素相同，前者未被使用：说明此方式已被记录
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, used, path, level + 1);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
