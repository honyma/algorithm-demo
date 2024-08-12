package linked;

import java.util.Stack;

/**
 * 删除链表的倒数第N个节点-用栈
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * @author mazehong
 * @date 2024/8/2
 */
public class DummyNode_RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode p = dummy;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        for (int i = 0; i <= n; i++) {
            p = stack.pop();
            if (p != null && i == n) {
                p.next = p.next.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode four = new ListNode(4);
        third.next = four;
        ListNode five = new ListNode(5);
        four.next = five;

        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }

        System.out.println();

        p = removeNthFromEnd(head, 2);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
