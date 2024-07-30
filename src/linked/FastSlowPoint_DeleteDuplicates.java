package linked;

/**
 * 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class FastSlowPoint_DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast.next = null;
            } else {
                slow = slow.next;
            }
            fast = slow.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        head.next = second;
        ListNode third = new ListNode(2);
        second.next = third;
        ListNode four = new ListNode(3);
        third.next = four;
        ListNode five = new ListNode(3);
        four.next = five;
        ListNode six = new ListNode(4);
        five.next = six;

        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }

        System.out.println();

        ListNode result = deleteDuplicates(head);
        p = result;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
