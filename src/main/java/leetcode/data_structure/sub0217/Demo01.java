package leetcode.data_structure.sub0217;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1}) + " = true");
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4}) + " = false");
        System.out.println(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}) + " = true");
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            // 创建一个 hash表
            /* ----- 空间 O(n) ----- */
            Set<Integer> map = new HashSet<>();
            /* +++++ 时间 O(n) +++++ */
            for (int num : nums) {
                if (!map.add(num)) {
                    // 遍历所有元素，若 hash 表中已存在，则返回 true
                    return true;
                }
            }
            return false;
        }
    }
}
