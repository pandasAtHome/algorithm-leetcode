package leetcode.double_pointer.sub0142;

import java.util.ArrayList;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        ListNode head;
        head = arrayToListNode(new int[]{3, 2, 0, -4}, 1);
        showResult(solution.detectCycle(head));

        head = arrayToListNode(new int[]{1,2}, 0);
        showResult(solution.detectCycle(head));

        head = arrayToListNode(new int[]{1}, -1);
        showResult(solution.detectCycle(head));

    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            /* 1、处理边界问题
             * 边界问题1：节点数为0
             * 边界问题2：节点数为1，但是 next 节点为空
             */
            if (head == null || head.next == null) {
                return null;
            }
            /* ----- 定义了2个指针：空间 O(1) ----- */
            // 2、定义一对快慢指针，快指针为慢指针移动速度的2倍
            ListNode slow = head, fast = head;
            // 3、若两指针相遇，则表示有环
            /* +++++ 遍历链表：时间 O(n) +++++ */
            do {
                // 3.1、细节问题1：无环：`fast == null` or `fast.next == null`
                /* +++++ 无环条件判断：时间 O(2n) +++++ */
                if (fast == null || fast.next == null) {
                    return null;
                }
                // 3.2、设置快慢指针的移动速度
                /* +++++ 有环判断 挪动指针：时间 O(3n) +++++ */
                slow = slow.next;
                fast = fast.next.next;
            } while (slow != fast);
            // 4、定义一个与 slow 指针相同移动速度的 pos 指针，指向 head
            ListNode pos = head;
            /* +++++ 遍历链表：时间 O(n) +++++ */
            while (pos != slow) {
                /* +++++ pos查询 挪动指针：时间 O(2n) +++++ */
                pos = pos.next;
                slow = slow.next;
            }
            // 5、当两指针相遇，则此时的节点为真正的 pos 节点
            return pos;
        }
    }

    public class Solution2 {
        public ListNode detectCycle(ListNode head) {
            // 1、定义一对快慢指针，快指针为慢指针移动速度的2倍
            ListNode slow = head, fast = head;
            // 2、若两指针相遇，则表示有环
            do {
                /* 2.1、处理边界问题
                 * 边界问题1：节点数为0
                 * 边界问题2：节点数为1，但是 next 节点为空
                 *
                 * 2.2、处理细节问题
                 * 细节问题1：无环：`fast == null` or `fast.next == null`
                 */
                if (fast == null || fast.next == null) {
                    return null;
                }
                // 2.3、设置快慢指针的移动速度
                slow = slow.next;
                fast = fast.next.next;
            } while (slow != fast);
            /* 3、定义一个与 slow 指针相同移动速度的 pos 指针，指向 head
             * 3.1、细节处理
             *  - 细节问题2：pos 节点查找时，使用 fast指针 代替 pos指针
             */
            fast = head;
            /* +++++ 遍历链表：时间 O(n) +++++ */
            while (fast != slow) {
                /* +++++ pos查询 挪动指针：时间 O(2n) +++++ */
                fast = fast.next;
                slow = slow.next;
            }
            // 4、当两指针相遇，则此时的节点为真正的 pos 节点
            return fast;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 数组 转 链表
     * @param nums
     * @param pos
     * @return
     */
    public static ListNode arrayToListNode(int[] nums, int pos) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode tmp = head;
        ListNode recall = null;
        for (int i = 1; i < n; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
            if (pos == i) {
                recall = tmp;
            }
        }
        if (recall != null) {
            tmp.next = recall;
        }
        return head;
    }

    /**
     * 显示结果节点
     * @param node
     */
    public static void showResult(ListNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ListNode head = node;
        do {
            result.add(node.val);
            node = node.next;
        } while (head != node);
        System.out.println(result.toString());
    }

}
