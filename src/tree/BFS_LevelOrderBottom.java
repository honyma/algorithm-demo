package tree;

import java.util.*;

/**
 * BFS广度优先搜索遍历数-层序遍历树
 * 从叶子节点，从下往上层序遍历树
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 *
 * @author mazehong
 * @date 2024/8/12
 */
public class BFS_LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //利用栈，从下往上层保存树节点
        Stack<List<Integer>> stack = new Stack<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(list);
        }

        List<List<Integer>> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


}
