package tree;

/**
 * @author mazehong
 * @date 2024/8/9
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
