package tree;

/**
 * 翻转二叉树-递归法
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 * @author mazehong
 * @date 2024/8/9
 */
public class Recursion_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void swap(TreeNode root) {
        //注意，这里翻转的是节点，不是值
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
