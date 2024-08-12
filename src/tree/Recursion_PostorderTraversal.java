package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序序遍历-递归法
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 *
 * @author mazehong
 * @date 2024/8/9
 */
public class Recursion_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}
