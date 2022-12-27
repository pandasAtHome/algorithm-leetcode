package leetcode.data_structure.sub0232;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo01 {
    public static void main(String[] args) {
        MyQueue myQueue = new Demo01().new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            /**
             * 1、定义两个栈：
             *   - 入栈：`inStack` 用于存放 `push` 入栈的值
             *   - 出栈：`outStack` 用于存放 `pop` 出栈的值
             */
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            // 2、执行 `push` 时，只管往 `inStack` 中插入
            inStack.push(x);
        }

        public int pop() {
            // 3、执行 `pop/peek` 时，每当 `outStack` 中被清空，则把 `inStack` 的值倾倒到 `outStack` 中
            in2Out();
            return outStack.pop();
        }

        public int peek() {
            in2Out();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        // 把 `inStack` 的值倾倒到 `outStack` 中
        private void in2Out() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
