package leetcode.data_structure.sub0128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}) + " = 4");
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}) + " = 9");
    }

    class Solution {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> numAndCount = new HashMap<>();
            int maxConnectNum = 0, curConnectNum, left, right;
            for (int num : nums) {
                if (numAndCount.containsKey(num)) {
                    continue;
                }
                left = numAndCount.getOrDefault(num - 1, 0);
                right = numAndCount.getOrDefault(num + 1, 0);
                curConnectNum = 1 + right + left;
                maxConnectNum = Math.max(maxConnectNum, curConnectNum);
                numAndCount.put(num, -1);
                numAndCount.put(num - left, curConnectNum);
                numAndCount.put(num + right, curConnectNum);
            }

            return maxConnectNum;
        }
    }

}
