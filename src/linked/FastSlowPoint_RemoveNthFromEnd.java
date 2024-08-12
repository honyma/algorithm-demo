package linked;


/**
 * 删除链表的倒数第N个节点-也可以用快慢指针解决
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * https://programmercarl.com/0019.%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E7%9A%84%E5%80%92%E6%95%B0%E7%AC%ACN%E4%B8%AA%E8%8A%82%E7%82%B9.html#%E6%80%9D%E8%B7%AF
 *
 * @author mazehong
 * @date 2024/8/2
 */
public class FastSlowPoint_RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        //先让快指针走N+1步
        for (int i = 0; i <=n ; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        while (fast != null) {
            //快慢指针同时移动一步，直到快指针到达终点
            fast = fast.next;
            slow = slow.next;
        }

        //到达终点后，移动慢指针到下一个节点即可
        slow.next = slow.next.next;

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
