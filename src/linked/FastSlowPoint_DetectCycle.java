package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表2
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * @author mazehong
 * @date 2024/8/2
 */
public class FastSlowPoint_DetectCycle {
    public static ListNode detectCycle1(ListNode head) {
        //第一种方法：使用哈希表
        Set<ListNode> set = new HashSet<>();
        ListNode pos = head;
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        //第二种方法：使用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //快指针走两步，慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //说明相交相遇
                ListNode node1 = fast;
                ListNode node2 = head;
                while (node2 != node1) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }


}
