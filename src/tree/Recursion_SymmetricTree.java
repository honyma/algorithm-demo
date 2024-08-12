package tree;

/**
 * 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * @author mazehong
 * @date 2024/8/12
 */
public class Recursion_SymmetricTree {

    //解题思路：先翻转树，再比较二棵树是否相等，如果与原树相同，则说明轴对称
    //利用递归思想
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        TreeNode left = invertTree(root.left);
        return equalTree(left, root.right);
    }

    //克隆树
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new TreeNode(root.val, cloneTree(root.left), cloneTree(root.right));
    }

    //翻转树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public boolean equalTree(TreeNode root1, TreeNode root2) {
        //结束
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return equalTree(root1.left, root2.left) && equalTree(root1.right, root2.right);
    }
}
