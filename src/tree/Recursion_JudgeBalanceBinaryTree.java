package tree;

/**
 * 判断是否是平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 *
 * @author mazehong
 * @date 2024/8/13
 */
public class Recursion_JudgeBalanceBinaryTree {
    //解题思路：
    //1.先用递归算出左右子树的最大高度差-》递归用后序遍历（左右中）
    //2.明确单层递归的逻辑（算左右子树的高度 和 左右子树的高度差，也就是最长路径）
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        //算最大路径
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        } /*else {
            //每层递归高度结果
            return Math.max(leftHeight, rightHeight) + 1;
        }*/
        //每层递归高度结果
        return Math.max(leftHeight, rightHeight) + 1;
        //return Math.max(leftHeight, leftRight) + 1;
    }
}
