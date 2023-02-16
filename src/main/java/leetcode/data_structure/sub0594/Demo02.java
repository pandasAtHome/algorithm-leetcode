package leetcode.data_structure.sub0594;

import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}) + " = 5");
        System.out.println(solution.findLHS(new int[]{1, 2, 3, 4}) + " = 2");
        System.out.println(solution.findLHS(new int[]{1, 1, 1, 1}) + " = 0");
        System.out.println(solution.findLHS(new int[]{1, 2, 1, 3, 0, 0, 2, 2, 1, 3, 3}) + " = 6");
    }

    class Solution {
        public int findLHS(int[] nums) {
            int result = 0;
            Map<Integer, int[]> map = new HashMap<>();
            int[] items;
            int left, right;
            for (int num : nums) {
                left = num - 1;
                right = num + 1;
                if (map.containsKey(left)) {
                    items = map.get(left);
                    items[2]++;
                    map.put(left, items);
                }
                if (map.containsKey(right)) {
                    items = map.get(right);
                    items[0]++;
                    map.put(right, items);
                }
                items = map.getOrDefault(num, new int[]{0, 0, 0});
                items[1]++;
                map.put(num, items);
            }

            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                items = entry.getValue();
                if (items[0] == 0 && items[2] == 0) {
                    continue;
                }
                result = Math.max(
                        result,
                        Math.max(items[0] + items[1], items[1] + items[2])
                );
            }

            return result;
        }
    }
}
