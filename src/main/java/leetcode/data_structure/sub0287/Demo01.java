package leetcode.data_structure.sub0287;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}) + " = 2");
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2}) + " = 3");
    }

    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            /* +++++ 时间 O(n) +++++ */
            // 寻找环
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            slow = 0;
            /* +++++ 时间 O(n) +++++ */
            // 寻找环的入口
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}
