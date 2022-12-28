package leetcode.data_structure.sub0155;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo02 {
    public static void main(String[] args) {
        MinStack minStack = new Demo02().new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin() + " = -3");
//        minStack.pop();
//        System.out.println(minStack.top() + " = 0");
//        System.out.println(minStack.getMin() + " = -2");

        /**
         * 	测试用例:["MinStack","push","push","push","getMin","pop","getMin"]
         * 			[[],[0],[1],[0],[],[],[]]
         * 	测试结果:[null,null,null,null,0,null,1]
         * 	期望结果:[null,null,null,null,0,null,0]
         */
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin() + " = 0");
        minStack.pop();
        System.out.println(minStack.getMin() + " = 0");
    }

    class MinStack {
        Deque<Integer> valStack;
        Integer minVal;

        public MinStack() {
            valStack = new ArrayDeque<>();
            minVal = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if (minVal >= val) {
                valStack.push(minVal);
                minVal = val;
            }
            valStack.push(val);
        }

        public void pop() {
            if (valStack.pop().equals(minVal)) {
                minVal = valStack.pop();
            }
        }

        public int top() {
            return valStack.peek();
        }

        public int getMin() {
            return minVal;
        }
    }
}
