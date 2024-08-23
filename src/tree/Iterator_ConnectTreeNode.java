package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充树每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
 *
 * @author mazehong
 * @date 2024/8/20
 */
public class Iterator_ConnectTreeNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    //使用层序遍历
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node cur;
        Node pre = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    //指向第一个节点
                    pre = queue.poll();
                    cur = pre;
                } else {
                    //依次指向下一个节点
                    cur = queue.poll();
                    pre.next = cur;
                    pre = pre.next;
                }
                //层序遍历记得加入左右节点(很重要)
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            //处理最后一个节点指向空
            pre.next = null;
        }

        return root;
    }

}
