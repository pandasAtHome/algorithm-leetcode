package leetcode.dynamic_programming.sub0376;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}) + " = 6");
        System.out.println(solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}) + " = 7");
        System.out.println(solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) + " = 2");
        System.out.println(solution.wiggleMaxLength(new int[]{3,3,3,2,5}) + " = 3");
    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            // 1、边界问题1：只有一个元素
            if (n < 2) {
                return n;
            }
            // 2、定义一个变量，记录：最大子序列长度
            /* ----- 空间 O(1) ----- */
            int maxLen = 1;
            int i = 0;
            // 3、定义一个开关，记录 下一个差值趋势：递增(true) or 递减(false)
            boolean upOrDown = true;
            // 4、排除开头相同的值 & 获取即将要寻找的趋势
            /* +++++ 时间 O(n) +++++ */
            while (++i < n) {
                // 过滤开头相同的值
                if (nums[i - 1] == nums[i]) {
                    continue;
                }
                // 获取下一个所需的趋势：递增 or 递减
                upOrDown = nums[i - 1] < nums[i];
                break;
            }

            // 5、寻找摆动序列
            /* +++++ 时间 O(n) +++++ */
            for (; i < n; i++) {
                if (nums[i - 1] == nums[i]) {
                    // 排除相同的数字
                    continue;
                }
                // 找到：波谷 or 峰值
                if (upOrDown == nums[i - 1] < nums[i]) {
                    maxLen++;
                    // 细节问题1：每次找到 `波谷` or `峰值` 后，反转，即可避免 `连续递减(增)` 问题
                    upOrDown = !upOrDown;
                }
            }
            return maxLen;
        }
    }
}
