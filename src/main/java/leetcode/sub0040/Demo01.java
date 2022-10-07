package leetcode.sub0040;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    class Solution {
        List<List<Integer>> result;
        int n;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            result = new ArrayList<>();
            // 1、对集合进行升序排序，过滤大于 target 的元素
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            if (!sortAndFilter(candidates, target)) {
                return result;
            }
            // 2、定义一个组合路径
            /* ----- 空间 O(L) ----- */
            Deque<Integer> path = new LinkedList<>();
            // 3、回溯寻找组合
            /* +++++ 时间 O(C_{n}^{L}) +++++ */
            backtrack(candidates, target, path, 0);

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

        private void backtrack(int[] candidates, int target, Deque<Integer> path, int level) {
            if (target == 0) {
                // 8、找到目标值
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = level; i < n; i++) {
                if (target - candidates[i] < 0) {
                    // 4、当前组合已超过 target
                    break;
                }
                if (i > level && candidates[i - 1] == candidates[i]) {
                    // 5、第二轮，开始，相邻的两个元素相同
                    continue;
                }
                // 6、添加元素
                path.add(candidates[i]);
                // 7、开始回溯
                backtrack(candidates, target - candidates[i], path, i + 1);
                path.removeLast();
            }
        }

    }
}
