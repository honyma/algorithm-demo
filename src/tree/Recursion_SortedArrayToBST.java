package tree;

/**
 * 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author mazehong
 * @date 2024/8/21
 */
public class Recursion_SortedArrayToBST {

    //数组：[-10,-3,0,5,9]
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return traversal(nums, 0 , nums.length);
    }

    public TreeNode traversal(int []nums, int left, int right) {
        //核心思想：递归（中序遍历）
        //遵循左闭右开原则(遵循这个原则很重要)
        if (left >= right) {
           return null;
        }
        int mid = (right + left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
