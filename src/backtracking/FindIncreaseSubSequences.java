package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 非递减子序列（递增子序列），而且要去重，不能重复
 * https://leetcode.cn/problems/non-decreasing-subsequences/
 *
 * @author mazehong
 * @date 2024/8/23
 */
public class FindIncreaseSubSequences {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, result, path);
        return result;


    }

    public static void backtracking(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> path) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        //终止条件
        if (startIndex >= nums.length) {
            return;
        }

        //遍历条件
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //判断
            if (set.contains(nums[i]) || (!path.isEmpty() && path.get(path.size()-1) > nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{4,6,7,6};
        //int nums[] = new int[]{4, 4, 3, 2, 1};
        List<List<Integer>> list = findSubsequences(nums);
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
