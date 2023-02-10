package leetcode.data_structure.sub0225;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {
    public static void main(String[] args) {
        MyStack myStack = new Demo01().new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top() + " = 2");;
        System.out.println(myStack.pop() + " = 2");;
        System.out.println(myStack.empty() + " = false");;
    }

    class MyStack {
        Queue<Integer> queueIn;
        Queue<Integer> queueOut;

        public MyStack() {
            queueIn = new LinkedList<>();
            queueOut = new LinkedList<>();
        }

        public void push(int x) {
            // 1、先向 In 队列插入元素
            queueIn.offer(x);
            // 2、将 Out 队列中的元素 倒入 In 队列（使得 In 队列为倒插入顺序）
            while (!queueOut.isEmpty()) {
                queueIn.offer(queueOut.poll());
            }
            // 3、交换 In 和 Out 队列（即：Out 为倒插入顺序，In 为空队列）
            Queue<Integer> tmp = queueIn;
            queueIn = queueOut;
            queueOut = tmp;
        }

        public int pop() {
            return queueOut.poll();
        }

        public int top() {
            return queueOut.peek();
        }

        public boolean empty() {
            return queueOut.isEmpty();
        }
    }
}
