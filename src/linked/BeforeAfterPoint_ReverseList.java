package linked;

/**
 * 翻转链表-用前后指针+临时指针
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author mazehong
 * @date 2024/8/1
 */
public class BeforeAfterPoint_ReverseList {
    public static ListNode reverseList(ListNode head) {
        //使用前后指针
        //注意，pre指针要设置为空
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
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

        p = reverseList(head);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
