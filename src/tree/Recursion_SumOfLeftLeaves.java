package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 *
 * @author mazehong
 * @date 2024/8/13
 */
public class Recursion_SumOfLeftLeaves {

    //第一种方式：使用层序遍历
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return sum;
    }

    //第二种方式：使用递归
    public int sumOfLeftLeaves2(TreeNode root) {
        //解题思路：使用后序遍历（左右中），最后相加
        //1.退出条件
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        //2.单层循环（左右中）
        int leftSum = sumOfLeftLeaves2(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum += root.left.val;
        }
        int rightSum = sumOfLeftLeaves2(root.right);

        return leftSum + rightSum;
    }
}
