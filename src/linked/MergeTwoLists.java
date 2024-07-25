package linked;

/**
 * @author mazehong
 * @date 2024/7/22
 */
public class MergeTwoLists {

    //https://leetcode.cn/problems/merge-two-sorted-lists/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode p = node;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        while (p1 != null) {
            p.next = p1;
        }

        while (p2 != null) {
            p.next = p2;
        }

        return node.next;
    }
}
