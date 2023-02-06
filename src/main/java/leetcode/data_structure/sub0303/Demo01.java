package leetcode.data_structure.sub0303;

public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        NumArray numArray = demo01.new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    class NumArray {
        int[] sums;

        NumArray(int[] nums) {
            int n = nums.length;
            /* ----- 空间 O(n) ----- */
            this.sums = new int[n + 1];
            // 1、记录 [0, i] 的累积和
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                this.sums[i + 1] = sums[i] + nums[i];
            }
        }

        int sumRange(int left, int right) {
            // 2、计算范围之和
            return sums[right + 1] - sums[left];
        }
    }
}
