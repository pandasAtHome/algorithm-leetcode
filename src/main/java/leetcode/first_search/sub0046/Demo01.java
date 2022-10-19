package leetcode.first_search.sub0046;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}).toString() + " = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
//        System.out.println(solution.permute(new int[]{0,1}).toString() + " = [[0,1],[1,0]]");
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // 结果集
            List<List<Integer>> result = new ArrayList<>();
            // 1、创建一个列表，记录每个数字是否被使用（已使用的数组不可重复使用）
            /* ----- 空间 O(n) ----- */
            boolean[] used = new boolean[nums.length];
            // 2、创建一个队列，用于存放当前的排序方式
            /* ----- 空间 O(n) ----- */
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            // 3、寻找可能的排序方式
            /* ----- 空间 O(n) ----- */
            /* +++++ 时间 O(n^2) +++++ */
            dfs(nums, used, result, deque, 0);
            return result;
        }

        private void dfs(int[] nums, boolean[] used, List<List<Integer>> result, ArrayDeque<Integer> deque, int level) {
            int n = nums.length;
            // 边界问题1：deque 的长度已达到最大，写入结果集
            if (n - 1 == level) {
                // 细节问题1：选用 `n - 1 == level` 最为递归的结束条件
                //   `n == level` 已可以作为结束条件，但是会多一次递归
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    // 当前数字已被使用
                    continue;
                }
                // 3.1、遍历数字，锁定当前要使用的数字（后续遍历不可重复用）
                used[i] = true;
                // 3.2、把当前数字加入队列
                deque.add(nums[i]);
                // 3.3、继续寻找下一个可用的数字
                dfs(nums, used, result, deque, level + 1);
                // 3.4、把当前数字移出队列，寻找下一种可能的排序方式
                deque.removeLast();
                // 3.5、解锁，对下一种可能的排序方式开放 当前数字的使用权限
                used[i] = false;
            }
        }
    }
}
