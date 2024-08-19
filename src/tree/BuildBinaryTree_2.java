package tree;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * @author mazehong
 * @date 2024/8/16
 */
public class BuildBinaryTree_2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //1.如果前序数组的大小为0，则返回null
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }
        //2.找到前序数组的根节点在中序数组的位置
        int rVal = preorder[preStart];
        int rIndex;
        for (rIndex = inStart; rIndex < inEnd; rIndex++) {
            if (inorder[rIndex] == rVal) {
                break;
            }
        }

        //3.建立根节点，递归构建返回左子树和返回的右子树
        TreeNode root = new TreeNode(rVal);
        int lenOfLeft = rIndex - inStart;
        //4.分隔中序数组左右子树(1, preStart + 1 + lenOfLeft), (inStart, rIndex)
        root.left = buildNode(preorder, preStart + 1, preStart + 1 + lenOfLeft, inorder, inStart, rIndex);


        //5.分隔前序数组左右子树(preStart + 1 + lenOfLeft, preEnd), (rIndex+1, inorder.length)
        root.right = buildNode(preorder, preStart + 1 + lenOfLeft, preEnd, inorder, rIndex + 1, inEnd);

        return root;

    }

}
