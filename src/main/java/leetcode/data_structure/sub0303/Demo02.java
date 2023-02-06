package leetcode.data_structure.sub0303;

public class Demo02 {
    public static void main(String[] args) {
        Demo02 demo01 = new Demo02();
        NumArray numArray = demo01.new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    class NumArray {
        int[] nums;

        NumArray(int[] nums) {
            this.nums = nums;
        }

        int sumRange(int left, int right) {
            int result = 0;
            for (int i = left; i <= right; i++) {
                result += nums[i];
            }
            return result;
        }
    }
}
