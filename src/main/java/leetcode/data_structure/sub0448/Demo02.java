package leetcode.data_structure.sub0448;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}) + " = [5,6]");
        System.out.println(solution.findDisappearedNumbers(new int[]{1, 1}) + " = [2]");
    }

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            int[] mem = new int[n + 1];
            for (int num : nums) {
                mem[num] = 1;
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (mem[i] == 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
