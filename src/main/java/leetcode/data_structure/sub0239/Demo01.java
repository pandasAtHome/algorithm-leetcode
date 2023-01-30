package leetcode.data_structure.sub0239;

import java.util.*;

// 单调性
public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println("[3,3,5,5,6,7] ----");
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println("[1] ----");
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
        System.out.println("[10,10,9,2] ----");
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));

    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            /*
             * 单调队列：
             *  - 对于：i < j，若 nums[i] <= nums[j]，抛弃 i，保留 j
             *  - 使得：queue 中的索引为 递增，且 索引对应的值为 递减
             */
            /* ----- 空间 O(k) ----- */
            Deque<Integer> queue = new LinkedList<>();
            int[] result = new int[n - k + 1];
            int left;
            /* +++++ 时间 O(n) +++++ */
            for (int j = 0; j < n; j++) {
                // 保证数值的递减性(索引值递增，对应的数值递减)
                while (!queue.isEmpty() && nums[j] >= nums[queue.getLast()]) {
                    queue.removeLast();
                }
                queue.offerLast(j);
                left = j - k + 1;
                if (left < 0) {
                    // 尚未完成初始化
                    continue;
                }
                // 移除不在窗口内的索引
                if (!queue.isEmpty() && queue.getFirst() < left) {
                    queue.removeFirst();
                }
                // 插入窗口中的最大值
                result[left] = nums[queue.getFirst()];
            }
            if (k > n) {
                // 边界问题1：`k > n` 直接返回队列中的最大值
                result[0] = nums[queue.getFirst()];
            }

            return result;
        }
    }
}
