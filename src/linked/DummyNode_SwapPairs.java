package linked;

/**
 * 两两交互链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * @author mazehong
 * @date 2024/8/1
 */
public class DummyNode_SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        //首先要定义一个虚拟节点
        ListNode dummy = new ListNode(-1, head);
        //定义当前指针指向dummy
        ListNode cur = dummy;

        //临时节点
        ListNode tmp;
        ListNode node1;
        ListNode node2;
        //这个条件判断很重要
        while (cur.next != null && cur.next.next != null) {
            tmp = cur.next.next.next;
            node1 = cur.next;
            node2 = cur.next.next;
            cur.next = node2;
            node2.next = node1;
            node1.next = tmp;
            cur = node1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
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

        p = swapPairs(head);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
