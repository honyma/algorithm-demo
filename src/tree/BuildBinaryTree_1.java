package tree;

/**
 * 从中序和后序遍历序列构建二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author mazehong
 * @date 2024/8/16
 */
public class BuildBinaryTree_1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        int rVal = postorder[postEnd - 1];
        int rIndex;
        for (rIndex = inBegin; rIndex < inEnd; rIndex++) {
            if (inorder[rIndex] == rVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rVal);
        int lenOfLeft = rIndex - inBegin;
        root.left = findNode(inorder, inBegin, rIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd-1);
        return root;
    }

    /*public void test(){
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootVal = postorder[postEnd - 1];
        int rootIndex;
        for (rootIndex = inBegin; rootIndex < inEnd; rootIndex++){
            if(inorder[rootIndex] == rootVal) {
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }*/
}
