package leetcode.data_structure.sub0155;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo01 {
    public static void main(String[] args) {
        MinStack minStack = new Demo01().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() + " = -3");
        minStack.pop();
        System.out.println(minStack.top() + " = 0");
        System.out.println(minStack.getMin() + " = -2");
    }

    class MinStack {
        Deque<Integer> valStack;
        Deque<Integer> minStack;

        public MinStack() {
            valStack = new ArrayDeque<>();
            // 1、创建一个辅助栈，用于记录每次 `push` 时，当前的最小值
            minStack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            valStack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            valStack.pop();
            minStack.pop();
        }

        public int top() {
            return valStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
