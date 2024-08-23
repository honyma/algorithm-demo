package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 非递减子序列，而且要去重，不能重复
 * https://leetcode.cn/problems/non-decreasing-subsequences/
 *
 * @author mazehong
 * @date 2024/8/23
 */
public class FindSubsequences {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int []used = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = 0;
        }
        Arrays.sort(nums);
        backtracking(nums, 0, result, path, used);
        return result;


    }

    public static void backtracking(int []nums, int startIndex, List<List<Integer>> result, List<Integer> path, int []used) {
        if (path.size() >=2) {
            result.add(new ArrayList<>(path));
        }
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i >0 && nums[i] == nums[i-1] && used[i-1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, i+1, result, path, used);
            path.remove(path.size() -1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{4,4,3,2,1};
        findSubsequences(nums);
    }
}
