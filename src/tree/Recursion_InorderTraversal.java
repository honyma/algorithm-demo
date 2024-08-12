package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历-递归法
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author mazehong
 * @date 2024/8/9
 */
public class Recursion_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
