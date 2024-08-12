package tree;

import java.util.*;

/**
 * BFS广度优先搜索遍历数-层序遍历树
 * 最右边子树的节点值
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * @author mazehong
 * @date 2024/8/12
 */
public class BFS_RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (size == 1) {
                    list.add(node.val);
                }
                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }
}
