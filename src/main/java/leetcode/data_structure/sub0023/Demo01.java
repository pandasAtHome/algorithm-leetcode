package leetcode.data_structure.sub0023;

import java.util.PriorityQueue;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        ListNode[] lists = new ListNode[]{
                new ListNode(2, new ListNode(6)),
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
        };
        System.out.println(solution.mergeKLists(lists));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        PriorityQueue<Status> queue;

        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            public Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            @Override
            public int compareTo(Status status) {
                return val - status.val;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            // 1、创建一个优先队列：递增
            queue = new PriorityQueue<>();
            for (ListNode node : lists) {
                if (node != null) {
                    // 2、链表数组入队
                    queue.offer(new Status(node.val, node));
                }
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            /* +++++ 时间 O(kn) +++++ */
            while (!queue.isEmpty()) {
                Status status = queue.poll();
                // 3、最小值截取：含有最小值的链表数组中的第一个值
                tail.next = status.ptr;
                tail = tail.next;
                // 4、链表数组再入队：把链表数组中剩余的元素再次入队
                if (status.ptr.next != null) {
                    queue.offer(new Status(status.ptr.next.val, status.ptr.next));
                }
            }
            return head.next;
        }
    }
}
