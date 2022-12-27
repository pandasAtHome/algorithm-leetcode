package leetcode.data_structure.sub0769;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
//        System.out.println(solution.maxChunksToSorted(new int[]{4,3,2,1,0}) + " = 1");
        System.out.println(solution.maxChunksToSorted(new int[]{1,0,2,3,4}) + " = 4");
    }

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            // 1、创建一个单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            for (int num : arr) {
                if (stack.isEmpty() || num >= stack.peek()) {
                    // 2、把递增排序的数字都入栈
                    stack.push(num);
                } else {
                    // 3、把递减的数字出栈
                    Integer maxVal = stack.pop();
                    while (!stack.isEmpty() && stack.peek() > num) {
                        stack.pop();
                    }
                    // 4、保留 递减序列中的最大值
                    stack.push(maxVal);
                }
            }
            return stack.size();
        }
    }
}
