package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历-递归法
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * @author mazehong
 * @date 2024/8/9
 */
public class Recursion_PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
