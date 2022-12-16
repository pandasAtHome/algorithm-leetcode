package leetcode.bitwise_operation.sub0260;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1,2,1,3,2,5})) + " = [3, 5]");
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{-1,0})) + " = [-1, 0]");
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{0,1})) + " = [1, 0]");
    }

    class Solution {
        public int[] singleNumber(int[] nums) {
            Map<Integer, Integer> counters = new HashMap<>();
            for (int num : nums) {
                if (counters.containsKey(num)) {
                    counters.remove(num);
                } else {
                    counters.put(num, 1);
                }
            }
            int[] result = new int[2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : counters.entrySet()) {
                result[i++] = entry.getKey();
            }

            return result;
        }
    }
}
