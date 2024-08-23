package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 求数组组成的所有子集
 * https://leetcode.cn/problems/subsets/
 *
 * @author mazehong
 * @date 2024/8/22
 */
public class ArraySubsets {

    //回溯算法
    //使用for循环横向遍历，使用递归纵向遍历
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, result, path);
        return result;
    }

    public static void backtracking(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        //使用for循环横向遍历，使用递归纵向遍历
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i+1, result, path);
            path.remove(path.size() -1);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3};
        List<List<Integer>> list = subsets(nums);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {

            List<Integer> sub = list.get(i);
            System.out.print("[");
            for (int j = 0; j < sub.size(); j++) {
                System.out.print(sub.get(j));
                System.out.print(",");
            }
            System.out.print("],");
        }
        System.out.print("]");

    }
}
