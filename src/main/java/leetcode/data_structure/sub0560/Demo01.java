package leetcode.data_structure.sub0560;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2) + " = 2");
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3) + " = 2");
        System.out.println(solution.subarraySum(new int[]{-1, -1, 1}, 0) + " = 1");
        System.out.println(solution.subarraySum(new int[]{1, -1, 0}, 0) + " = 3");
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int result = 0, sum = 0;
            Integer cnt;
            // 创建一个 map，记录前缀和对应的个数：`{前缀和: 个数}`

            Map<Integer, Integer> map = new HashMap<>();
            /*
             * - `nums` 数组中，可能不存在 `sum == 0` 的情况
             * - 但是存在 `sum == k`，即 `sum - k = 0` 的情况
             * - 所以初始化一个 `map[0] = 1`
             */
            map.put(0, 1);
            for (int num : nums) {
                // 计算前缀和
                sum += num;
                if ((cnt = map.get(sum - k)) != null) {
                    result += cnt;
                }
                // 记录前缀和的个数
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return result;
        }
    }
}
