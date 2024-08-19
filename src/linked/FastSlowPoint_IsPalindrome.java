package linked;

import java.util.List;

/**
 * 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author mazehong
 * @date 2024/8/19
 */
public class FastSlowPoint_IsPalindrome {

    //使用快慢指针，进行切割链表
    //再依次比较两个链表
    public boolean isPalindrome(ListNode head) {
        //执行快慢指针，让快指针走到结束，此时慢指针的位置，就是切割的位置
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //切割成两个链表-很重要
        pre.next = null;

        ListNode cur1 = head;
        ListNode cur2 = convertLikedList(slow);

        while (cur1 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return true;
    }

    public ListNode convertLikedList(ListNode head) {
        //双指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
