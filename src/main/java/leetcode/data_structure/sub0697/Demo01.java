package leetcode.data_structure.sub0697;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}) + " = 2");
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}) + " = 6");
    }

    class Solution {
        public int findShortestSubArray(int[] nums) {
            /*
             * 定义一个 hash 表，记录每个数字的：
             *   - `[第一次出现位置, 最后一次出现位置, 出现次数]`
             */
            /* ----- 空间 O(n) ----- */
            Map<Integer, int[]> map = new HashMap<>();
            int n = nums.length, num;
            int[] pos;
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                num = nums[i];
                pos = map.getOrDefault(num, new int[]{i, i, 0});
                pos[1] = i;
                pos[2]++;
                map.put(num, pos);
            }
            int maxDeep = 0, minLen = n;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                pos = entry.getValue();
                // 遍历 hash 表，找出出现次数最多的最多子数组
                if (maxDeep < pos[2]) {
                    maxDeep = pos[2];
                    minLen = pos[1] - pos[0] + 1;
                } else if (maxDeep == pos[2]) {
                    minLen = Math.min(minLen, pos[1] - pos[0] + 1);
                }
            }

            return minLen;
        }
    }
}
