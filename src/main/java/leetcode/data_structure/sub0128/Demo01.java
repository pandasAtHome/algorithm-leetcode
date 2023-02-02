package leetcode.data_structure.sub0128;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}) + " = 4");
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}) + " = 9");
    }

    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            // 1、把数组中的元素写入 `hash` 表
            /* ----- 空间 O(n) ----- */
            Set<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                hashSet.add(num);
            }
            // 最长连续序列的长度 | 左边界 | 右边界
            int maxConnectLen = 0, left, right;
            // 2、遍历所有数字
            /* +++++ 时间 O(n) +++++ */
            for (int num : nums) {
                if (!hashSet.contains(num)) {
                    continue;
                }
                // 2.1、找出该数字所属连续序列的左右边界
                left = num - 1;
                right = num + 1;
                // 获取左边界
                while (hashSet.contains(left)) {
                    // 细节问题1：移除已检测过的值
                    hashSet.remove(left--);
                }
                // 获取右边界
                while (hashSet.contains(right)) {
                    // 移除已检测过的值
                    hashSet.remove(right++);
                }
                // 2.2、并把这些值从 `hash` 表中移除
                maxConnectLen = Math.max(maxConnectLen, right - left - 1);
            }

            return maxConnectLen;
        }
    }

}
