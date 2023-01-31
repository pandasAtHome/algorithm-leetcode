package leetcode.data_structure.sub0001;

import java.util.Arrays;
import java.util.HashMap;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println("[0, 1] ----");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println("[1, 2] ----");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,2,4}, 6)));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            if (n == 2) {
                return nums;
            }
            /* ----- 空间 O(n) ----- */
            // 建立一个 `hash` 表，记录每个数字及其在数组中的索引
            HashMap<Integer, Integer> ans = new HashMap<>();
            /* +++++ 时间 O(n) +++++ */
            // 遍历每个数字，计算出与目标值之差 `diff = target - nums[i]`
            for (int i = 0; i < n; i++) {
                // 查看差值是否在 `hash` 表中
                if (ans.containsKey(target - nums[i])) {
                    return new int[]{ans.get(target - nums[i]), i};
                }
                ans.put(nums[i], i);
            }
            return null;
        }
    }
}
