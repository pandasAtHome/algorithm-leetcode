package leetcode.data_structure.sub0503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println("[2, -1, 2] -----");
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println("[2, 3, 4, -1, 4] -----");
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length, idx;
            // 1、初始化，所有值都为 -1
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = -1;
            }
            if (n == 1) {
                return result;
            }
            // 2、定义一个数组索引单调栈
            /* ----- 空间 O(n) ----- */
            Deque<Integer> stack = new ArrayDeque<>();
            // 3、复制 数组长度，使其变成环
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < 2 * n - 1; i++) {
                idx = i % n;
                while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                    // 4、找到 下一个较大者，出栈
                    result[stack.poll()] = nums[idx];
                }
                // 5、索引入栈
                stack.push(idx);
            }

            return result;
        }
    }
}
