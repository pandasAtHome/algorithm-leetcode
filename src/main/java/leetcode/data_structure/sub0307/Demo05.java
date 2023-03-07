package leetcode.data_structure.sub0307;

public class Demo05 {
    public static void main(String[] args) {
        Demo05 demo01 = new Demo05();
        NumArray numArray;
//        numArray = demo01.new NumArray(new int[]{1, 3, 5});
//        System.out.println(numArray.sumRange(0, 2) + " = 9");
//        numArray.update(1, 2);
//        System.out.println(numArray.sumRange(0, 2) + " = 8");

        /**
         * 	测试用例:["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
         * 			[[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]]
         * 	测试结果:[null,null,null,null,6,null,27,null,21,28,null]
         * 	期望结果:[null,null,null,null,6,null,32,null,26,27,null]
         */
        numArray = demo01.new NumArray(new int[]{7, 2, 7, 2, 0});
        System.out.println("[7, 2, 7, 2, 0]");
        numArray.update(4, 6);
        System.out.println("[7, 2, 7, 2, 6]");
        numArray.update(0, 2);
        System.out.println("[2, 2, 7, 2, 6]");
        numArray.update(0, 9);
        System.out.println("[9, 2, 7, 2, 6]");
        System.out.println(numArray.sumRange(4, 4) + " = 6");
        numArray.update(3, 8);
        System.out.println("[9, 2, 7, 8, 6]");
        System.out.println(numArray.sumRange(0, 4) + " = 32");
        numArray.update(4, 1);
        System.out.println("[9, 2, 7, 8, 1]");
        System.out.println(numArray.sumRange(0, 3) + " = 26");
        System.out.println(numArray.sumRange(0, 4) + " = 27");
        numArray.update(0, 4);
        System.out.println("[4, 2, 7, 8, 1]");

    }

    class NumArray {
        int[] sums;
        int[] nums;
        int size;
        boolean isUpdate = false;

        public NumArray(int[] nums) {
            this.size = nums.length;
            this.nums = nums;
            this.sums = new int[size + 1];
            this.sums[0] = 0;
            for (int i = 0; i < size; i++) {
                this.sums[i + 1] = sums[i] + nums[i];
            }
        }

        public void update(int index, int val) {
            this.isUpdate = true;
            this.nums[index] = val;
        }

        public int sumRange(int left, int right) {
            if (isUpdate) {
                update();
            }
            return sums[right + 1] - sums[left];
        }

        protected void update() {
            this.isUpdate = false;
            for (int i = 0; i < size; i++) {
                this.sums[i + 1] = sums[i] + nums[i];
            }
        }
    }
}
