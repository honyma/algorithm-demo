package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶子节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 *
 * @author mazehong
 * @date 2024/8/15
 */
public class Recursion_SumNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        return reversal(root, path);
    }

    public int reversal(TreeNode root, List<Integer> path) {
        if (root == null) {
            return 0;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
            }
            return Integer.parseInt(sb.toString());
        }

        int leftSum = 0;
        if (root.left != null) {
            leftSum = reversal(root.left, path);
            path.remove(path.size() - 1);
        }
        int rightSum = 0;
        if (root.right != null) {
            rightSum = reversal(root.right, path);
            path.remove(path.size() - 1);
        }

        return leftSum + rightSum;
    }
}
