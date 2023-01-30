package leetcode.data_structure.sub0239;

import java.util.Arrays;
import java.util.PriorityQueue;

// time out limited
public class Demo10 {
    public static void main(String[] args) {
        Solution solution = new Demo10().new Solution();
        System.out.println("[3,3,5,5,6,7]");
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println("[1]");
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int stop = Math.min(n, k);
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < stop; i++) {
                pq.offer(nums[i]);
            }
            if (k >= n) {
                return new int[]{pq.peek()};
            }
            int[] result = new int[n - k + 1];
            int idx = 0;
            for (int i = k; i < n; i++) {
                result[idx++] = pq.peek();
                pq.remove(nums[i - k]);
                pq.offer(nums[i]);
            }
            result[idx++] = pq.peek();

            return result;
        }
    }
}
