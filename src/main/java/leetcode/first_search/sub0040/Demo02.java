package leetcode.first_search.sub0040;

import java.util.*;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    class Solution {
        List<List<Integer>> result;
        int n;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            result = new ArrayList<>();
            if (!sortAndFilter(candidates, target)) {
                return result;
            }
            boolean[] used = new boolean[n];
            Deque<Integer> path = new LinkedList<>();
            backtrack(candidates, target, used, path, 0);

            return result;
        }

        private boolean sortAndFilter(int[] candidates, int target) {
            n = candidates.length;
            Arrays.sort(candidates);
            while (n > 0 && candidates[n - 1] > target) {
                n--;
            }
            return n > 0;
        }

        private void backtrack(int[] candidates, int target, boolean[] used, Deque<Integer> path, int level) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = level; i < n; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                if (i > level && candidates[i - 1] == candidates[i] && !used[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                used[i] = true;
                backtrack(candidates, target - candidates[i], used, path, i + 1);
                used[i] = false;
                path.removeLast();
            }
        }

    }
}
