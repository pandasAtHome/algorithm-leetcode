package leetcode.data_structure.sub0594;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}) + " = 5");
        System.out.println(solution.findLHS(new int[]{1, 2, 3, 4}) + " = 2");
        System.out.println(solution.findLHS(new int[]{1, 1, 1, 1}) + " = 0");
        System.out.println(solution.findLHS(new int[]{1, 2, 1, 3, 0, 0, 2, 2, 1, 3, 3}) + " = 6");
    }

    class Solution {
        public int findLHS(int[] nums) {
            int result = 0;
            /* ----- 空间 O(n) ----- */
            // 定义一个 hash表，记录每个数字出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            /* +++++ 时间 O(n) +++++ */
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int cur, right;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cur = entry.getKey();
                right = cur + 1;
                if (!map.containsKey(right)) {
                    // 不存在右侧数字，跳过
                    continue;
                }
                // 若当前数字存在右侧数字(比它 大1)，计算最大长度
                result = Math.max(result, map.get(right) + entry.getValue());
            }

            return result;
        }
    }
}
