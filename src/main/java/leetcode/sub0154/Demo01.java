package leetcode.sub0154;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findMin(new int[]{1,3,5}) + " = 1");
        System.out.println(solution.findMin(new int[]{2,2,2,0,1}) + " = 0");
    }

    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int left = 0, right = n - 1, mid;
            /* +++++ 二分查找退出条件判断：时间 O(log n) +++++ */
            while (left < right) {
                /* +++++ 赋值：时间 O(1) +++++ */
                /* +++++ 计算：时间 2 * O(1) +++++ */
                mid = (left + right) / 2;
                /* +++++ 元素查找 & 比较：时间 3 * O(1) +++++ */
                /* +++++ 移动指针 & 计算：时间 2 * O(1) +++++ */
                if (nums[mid] > nums[right]) {
                    // 波谷在右区间
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    // 波谷在左区间
                    right = mid;
                } else {
                    // 暂时无法识别
                    // {0, 1, 2, 2, 2}
                    //        |
                    // nums[mid] = 2, nums[right] = 2
                    right--;
                }
            }
            return nums[left];
        }
    }
}
