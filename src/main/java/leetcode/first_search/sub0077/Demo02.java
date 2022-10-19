package leetcode.first_search.sub0077;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.combine(4, 2) + " = [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]");
        System.out.println(solution.combine(1, 1) + " = [[1]]");
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            // 结果集
            List<List<Integer>> result = new ArrayList<>();
            // 1、定义一个队列，用于记录当前查找的排序方式
            int[] queue = new int[k];
            // 2、定义一个计数器，用于记录当前排序方式队列的长度
            int count = 0;
            // 3、开始寻找所有可能的排序方式
            dfs(result, queue, count, n, k, 1);
            return result;
        }

        private void dfs(List<List<Integer>> result, int[] queue, int count, int n, int k, int pos) {
            // 3.1、排序组合达到最大数量，把排序方式加入结果集
            if (count == k) {
                List<Integer> temp = new ArrayList<>();
                for (int num : queue) {
                    temp.add(num);
                }
                result.add(temp);
                return;
            }
            // 3.2、细节问题1：当剩余的数字，不够 组成一个长度为 k 的数组时，可以停止后续操作
            int stop = n - (k - count) + 1;
            for (int i = pos; i <= stop; i++) {
                // 3.3、锁定状态：计数 +1
                // 3.4、数字加入队列
                queue[count++] = i;
                // 3.5、寻找下一个数字
                dfs(result, queue, count, n, k, i + 1);
                // 3.6、数字出队，寻找下一种可能
                // 3.7、解锁状态：计数 -1
                count--;
            }
        }
    }
}
