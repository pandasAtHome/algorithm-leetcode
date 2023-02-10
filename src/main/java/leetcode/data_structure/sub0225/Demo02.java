package leetcode.data_structure.sub0225;

import java.util.LinkedList;
import java.util.Queue;

public class Demo02 {
    public static void main(String[] args) {
        MyStack myStack = new Demo02().new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(1);
        System.out.println(myStack.top() + " = 2");;
        System.out.println(myStack.pop() + " = 2");;
        System.out.println(myStack.empty() + " = false");;
    }

    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
