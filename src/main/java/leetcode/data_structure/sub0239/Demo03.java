package leetcode.data_structure.sub0239;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
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
            int stop = Math.min(n, k);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] == b[1]) {
                    // 值相同时，按位置顺序排序
                    return a[0] - b[0];
                }
                // 值不同，从大到小排序
                return b[1] - a[1];
            });
            for (int i = 0; i < stop; i++) {
                pq.offer(new int[]{i, nums[i]});
            }
            if (k >= n) {
                return new int[]{pq.peek()[1]};
            }
            int[] result = new int[n - k + 1];
            int left;
            result[0] = pq.peek()[1];
            for (int i = k; i < n; i++) {
                pq.offer(new int[]{i, nums[i]});
                left = i - k;
                while (pq.peek()[0] <= left) {
                    // 移除过期的最大值
                    pq.poll();
                }
                result[left + 1] = pq.peek()[1];
            }

            return result;
        }
    }
}
