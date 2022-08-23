package leetcode.sub0665;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.checkPossibility(new int[]{4, 2, 3}) + " = true");
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}) + " = false");
        System.out.println(solution.checkPossibility(new int[]{3, 4, 2, 3}) + " = false");
        System.out.println(solution.checkPossibility(new int[]{1, 4, 1, 2}) + " = true");
    }

    class Solution {
        public boolean checkPossibility(int[] nums) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int length = nums.length;
            // 1、边界问题：只有一个元素
            if (length == 1) {
                return true;
            }
            /* 2、比较前两位大小，获取剩余的可修改次数
             *  - 合规：剩余 1 次
             *  - 不合规：使用 1 次修改机会，剩余 0 次
             */
            int changeNum = nums[0] <= nums[1] ? 1 : 0;
            // 3、边界问题：循环去除头尾 => [1, n - 1]
            int stop = length - 1;
            // 下一个元素的值
            int next;
            // 4、统计不合规次数
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 1; i < stop; i++) {
                // 4.1、合规
                /* +++++ 条件判断：时间 O(n) +++++ */
                if (nums[i] <= (next = nums[i + 1])) {
                    continue;
                }
                /* +++++ 后面的操作，在整个循环合算：时间 O(1) +++++ */
                //  changeNum-- == 0 : 此部分最多执行 2 次
                //  修改值 : 此部分最多执行 1 次

                // 4.2、检查是否还有修改次数，并使用 1次 修改机会
                if (changeNum-- == 0) {
                    return false;
                }
                if (nums[i - 1] > next) {
                    // 4.3、`prev > next`  =>  `修改 next 的值`
                    // { 3, 4, 2} => {3, 4, 4}
                    nums[i + 1] = nums[i];
                } else {
                    // 4.4、`prev <= next`  =>  `修改 当前 的值`
                    // { 1, 4, 1} => {1, 1, 1}
                    nums[i] = next;
                }
            }
            // 5、默认所有都合规
            return true;
        }
    }
}
