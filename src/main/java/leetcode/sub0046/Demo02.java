package leetcode.sub0046;

import java.util.*;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}).toString() + " = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
//        System.out.println(solution.permute(new int[]{0,1}).toString() + " = [[0,1],[1,0]]");
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // 结果集
            List<List<Integer>> result = new ArrayList<>();
            // 查询可能的排序方式
            dfs(nums, result, 0);
            return result;
        }

        private void dfs(int[] nums, List<List<Integer>> result, int level) {
            String arrow = getLevelArrow(level);
            int n = nums.length;
            // deque 的长度已达到最大，写入结果集
            if (n == level) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }
                result.add(list);
                // todo：输出结果
                show(arrow, "level = " + level);
                show(arrow, result.toString());
                show(arrow, "找到目标，此队列搜索结束");
                return;
            }
            for (int i = level; i < n; i++) {
                // todo：输出结果
                if (level == 0) {
                    show(arrow, "===============");
                }
                // todo：输出结果
                show(arrow, "level = " + level + ", i = " + i);
                // 修改当前节点状态
                swap(nums, i, level);
                // todo：输出结果
                show(arrow, "修改状态后：" + Arrays.toString(nums));
                // 搜索子节点
                show(arrow, "寻找子节点");
                dfs(nums, result, level + 1);
                // 恢复当前节点状态
                swap(nums, i, level);
                // todo：输出结果
                show(arrow, "还原状态后：" + Arrays.toString(nums));
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

        private String getLevelArrow(int level) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("--");
            }
            sb.append(">");
            return sb.toString();
        }

        private void show(String arrow, String msg) {
            System.out.println(arrow + " " + msg);
        }
    }
}
