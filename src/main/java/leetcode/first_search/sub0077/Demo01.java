package leetcode.first_search.sub0077;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.combine(4, 2) + " = [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]");
        System.out.println(solution.combine(1, 1) + " = [[1]]");
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            // 结果集
            List<List<Integer>> result = new ArrayList<>();
            // 1、定义一个队列，用于记录当前查找的排序方式
            /* ----- 空间 O(k) ----- */
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            // 2、定义一个计数器，用于记录当前排序方式队列的长度
            /* ----- 空间 O(1) ----- */
            int count = 0;
            // 3、开始寻找所有可能的排序方式
            /* ----- 空间 O(C_{k}^{n}) ----- */
            /* +++++ 时间 O(C_{k}^{n}) +++++ */
            dfs(result, deque, count, n, k, 1);
            return result;
        }

        private void dfs(List<List<Integer>> result, ArrayDeque<Integer> deque, int count, int n, int k, int pos) {
            // 3.1、排序组合达到最大数量，把排序方式加入结果集
            if (count == k) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = pos; i <= n; i++) {
                // 3.2、锁定状态：计数 +1
                count++;
                // 3.3、数字加入队列
                deque.add(i);
                // 3.4、寻找下一个数字
                dfs(result, deque, count, n, k, i + 1);
                // 3.5、数字出队，寻找下一种可能
                deque.removeLast();
                // 3.6、解锁状态：计数 -1
                count--;
            }
        }
    }
}
