package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历二叉树的所有路径
 * 递归+回溯
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * @author mazehong
 * @date 2024/8/13
 */
public class Recursion_Backtracking_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        traversal(root, list1, list2);
        return list2;
    }

    public void traversal(TreeNode root, List<Integer> path, List<String> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);//要先加节点，后面才能拼接
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            int size = path.size();
            for (int i = 0; i < size; i++) {
                sb.append(path.get(i));
                if (i < size -1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
        }

        //一定要判断非空，只有非空节点才需要回溯和继续递归
        if (root.left != null) {
            traversal(root.left, path, result);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            traversal(root.right, path, result);
            path.remove(path.size()-1);
        }
    }
}
