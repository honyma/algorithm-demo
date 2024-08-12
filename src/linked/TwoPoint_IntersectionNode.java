package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表相交的节点-链表相交
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/
 *
 * @author mazehong
 * @date 2024/8/2
 */
public class TwoPoint_IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //第一种方法：
        /*Set<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }

        p = headB;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            p = p.next;
        }
        return null;*/

        //第二种方法：用两个指针,两个链表各遍历一遍，如果两个指针走到一块相等，则说明相交
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }

        return A;
    }

    public static void main(String[] args) {
        //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        ListNode headA = new ListNode(4);
        ListNode secondA = new ListNode(1);
        headA.next = secondA;
        ListNode thirdA = new ListNode(8);
        secondA.next = thirdA;
        ListNode fourA = new ListNode(4);
        thirdA.next = fourA;
        ListNode fiveA = new ListNode(5);
        fourA.next = fiveA;

        ListNode p = headA;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }

        System.out.println();


        ListNode headB = new ListNode(5);
        ListNode secondB = new ListNode(0);
        headB.next = secondB;
        ListNode thirdB = new ListNode(1);
        secondB.next = thirdB;
        ListNode fourB = new ListNode(8);
        thirdB.next = fourB;
        ListNode fiveB = new ListNode(4);
        fourB.next = fiveB;
        ListNode sixB = new ListNode(5);
        fiveB.next = sixB;

        p = headB;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }

        System.out.println();

        p = getIntersectionNode(headA, headB);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
