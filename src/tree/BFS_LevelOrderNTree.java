package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/
 *
 * @author mazehong
 * @date 2024/8/12
 */
public class BFS_LevelOrderNTree {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            while (size > 0) {
                Node node = queue.poll();
                l.add(node.val);
                size--;
                for (int i = 0; i < node.children.size(); i++) {
                    queue.offer(node.children.get(i));
                }
            }
            list.add(l);
        }

        return list;
    }
}
