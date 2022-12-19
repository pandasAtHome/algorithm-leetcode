package leetcode.data_structure.sub0448;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}) + " = [5,6]");
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 1, 2, 3, 1}) + " = [5,6,8]");
        System.out.println(solution.findDisappearedNumbers(new int[]{1, 1}) + " = [2]");
    }

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            /* ----- 空间 O(1) ----- */
            int n = nums.length;
            /**
             * 1、求出 `nums` 中每个数字的余数 `x = (nums[i] - 1) % n`
             *  - 由于 `0 <= i < n` 而 `1 <= nums[i] <= n`
             *  - 所以 取余时，需要使用 `nums[i] - 1`
             */
            /* +++++ 时间 O(n) +++++ */
            for (int num : nums) {
                int x = (num - 1) % n;
                // 2、为了不影响后续数字的`求余结果`，对 `nums[x] += n`
                nums[x] += n;
            }
            List<Integer> result = new ArrayList<>();
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                // 3、找出 `nums[i] <= n` 的索引位 `i + 1` 即为缺失的数字
                if (nums[i] <= n) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
}
