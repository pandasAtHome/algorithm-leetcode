package leetcode.data_structure.sub0307;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        NumArray numArray;
//        numArray = demo01.new NumArray(new int[]{1, 3, 5});
//        System.out.println(numArray.sumRange(0, 2) + " = 9");
//        numArray.update(1, 2);
//        System.out.println(numArray.sumRange(0, 2) + " = 8");
        numArray = demo01.new NumArray(new int[]{7, 2, 7, 2, 3, 1});

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

    /**
     * 线段树：
     *  - 叶子结点：存储 `nums` 数组中的每个元素数值
     *  - 子节点：存储区间范围内的数值
     */
    class NumArray {
        int[] segmentTree;
        int size;

        public NumArray(int[] nums) {
            this.size = nums.length;
            this.segmentTree = new int[size * 4];
            build(0, 0, size - 1, nums);
        }

        public void update(int index, int val) {
            change(index, val, 0, 0, size - 1);
        }

        public int sumRange(int left, int right) {
            return range(left, right, 0, 0, size - 1);
        }

        protected void build(int node, int s, int e, int[] nums) {
            if (s == e) {
                this.segmentTree[node] = nums[s];
                return;
            }
            int m = getMidVal(s, e);
            build(node * 2 + 1, s, m, nums);
            build(node * 2 + 2, m + 1, e, nums);
            this.segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        protected void change(int index, int val, int node, int s, int e) {
            if (s == e) {
                this.segmentTree[node] = val;
                return;
            }
            int m = getMidVal(s, e);
            if (index <= m) {
                change(index, val, node * 2 + 1, s, m);
            } else {
                change(index, val, node * 2 + 2, m + 1, e);
            }
            this.segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        protected int range(int left, int right, int node, int s, int e) {
            if (left == s && right == e) {
                return segmentTree[node];
            }
            int m = s + (e - s) / 2;
            if (right <= m) {
                return range(left, right, node * 2 + 1, s, m);
            } else if (left > m) {
                return range(left, right, node * 2 + 2, m + 1, e);
            } else {
                return range(left, m, node * 2 + 1, s, m) + range(m + 1, right, node * 2 + 2, m + 1, e);
            }
        }

        private int getMidVal(int s, int e) {
            return (s + e) / 2;
        }
    }
}
