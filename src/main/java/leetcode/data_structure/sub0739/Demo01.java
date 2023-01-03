package leetcode.data_structure.sub0739;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) + " = [1,1,4,2,1,1,0,0]");
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 40, 50, 60})) + " = [1,1,1,0]");
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 60, 90})) + " = [1,1,0]");
    }

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];
            // 1、创建一个栈，记录未找到较大者的数值
            Deque<Integer> stack = new ArrayDeque<>();
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                // 2、给前面的数值匹配较大者
                while (!stack.isEmpty()) {
                    int prevIndex = stack.peek();
                    if (temperatures[i] <= temperatures[prevIndex]) {
                        break;
                    }
                    stack.pop();
                    result[prevIndex] = i - prevIndex;
                }
                // 3、当前值入队
                stack.push(i);
            }
            return result;
        }
    }
}
