package linked;


/**
 * @author mazehong
 * @date 2024/7/22
 */
public class ListNode {

    ListNode next;

    int val;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
