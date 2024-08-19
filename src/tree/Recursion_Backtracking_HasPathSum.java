package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和
 * https://leetcode.cn/problems/path-sum/
 * https://leetcode.cn/problems/path-sum-ii/description/
 *
 * @author mazehong
 * @date 2024/8/14
 */
public class Recursion_Backtracking_HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                return true;
            }
        }

        //这里的targetSum是上一个节点计算后的值
        if (root.left != null) {
            boolean leftb = hasPathSum(root.left, targetSum);
            if (leftb) {
                return true;
            }
        }
        if (root.right != null) {
            boolean rightb = hasPathSum(root.right, targetSum);
            if (rightb) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        recursionPathSum(root, targetSum, result, path);
        return result;
    }

    //使用前序遍历
    public void recursionPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                //这里一定要注意，一定要new一个新的数组，不然是浅拷贝，path的值会变
                result.add(new ArrayList<>(path));
            }
        }

        //左子树
        if (root.left != null) {
            recursionPathSum(root.left, targetSum, result, path);
            path.remove(path.size() - 1);
        }
        //右子树
        if (root.right != null) {
            recursionPathSum(root.right, targetSum, result, path);
            path.remove(path.size() - 1);
        }
    }
}
