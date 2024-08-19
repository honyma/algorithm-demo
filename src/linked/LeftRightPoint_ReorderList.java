package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * https://leetcode.cn/problems/reorder-list/
 *
 * @author mazehong
 * @date 2024/8/15
 */
public class LeftRightPoint_ReorderList {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int left = 0;
        int right = list.size() - 1;
        cur = head;
        while (left < right) {
            cur.next = list.get(left);
            cur = cur.next;
            cur.next = list.get(right);
            cur = cur.next;
            left++;
            right--;
        }

        //处理最后一个元素
        cur.next = list.get(left);
        //这里最后一步这里设置null很重要，不然链表不会结束
        cur.next.next = null;
    }
}
