package linked;

/**
 * 移除链表元素
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author mazehong
 * @date 2024/8/1
 */
public class DummyNode_RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        //由于头结点不好处理，所以要定义一个虚拟节点

    }

    public static void main(String[] args) {
        //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
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

        p = removeElements(head, 5);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
