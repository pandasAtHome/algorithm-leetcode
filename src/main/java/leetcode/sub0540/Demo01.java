package leetcode.sub0540;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1}) + " = 1");
        System.out.println(solution.singleNonDuplicate(new int[]{1,1}) + " = -1");
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2}) + " = 2");
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}) + " = 2");
        System.out.println(solution.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}) + " = 10");
        System.out.println(solution.singleNonDuplicate(new int[]{3,3,7,7,10,11,11,12,12}) + " = 10");
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,7,7,10,11,11}) + " = 10");
    }

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int n = nums.length;
            // 1、细节问题2：nums 的长度为偶数，没有独立数
            if (n % 2 == 0) {
                return -1;
            }
            // 2、找出第一个 `nums[mid] != nums[mid + 1]`，皆可找到独立数：
            int left = 0, right = n - 1, mid;
            /* +++++ 二分查找退出条件判断：时间 O(log n) +++++ */
            while (left < right) {
                /* +++++ 赋值：时间 2 * O(1) +++++ */
                /* +++++ 计算：时间 4 * O(1) +++++ */
                mid = (left + right) / 2;
                // 3、计算出偶数下标：每次只比较 `偶数下标` 和 `奇数下标`
                mid -= (mid & 1);
                // 4、独立数出现之前：`nums[偶数] == nums[奇数]`
                /* +++++ 元素查找 & 比较：时间 3 * O(1) +++++ */
                /* +++++ 移动指针：时间 O(1) +++++ */
                if (nums[mid] == nums[mid + 1]) {
                    // 4.1、独立数在右区间
                    left = mid + 2;
                } else {
                    // 5、独立数出现之后：`nums[偶数] != nums[奇数]`
                    // 5.1、独立数在左区间
                    right = mid;
                }
            }
            return nums[left];
        }
    }
}
