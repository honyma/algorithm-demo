package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * @author mazehong
 * @date 2024/9/4
 */
public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        combinationSum(k, n, 1, 0);
        return result;
    }

    public void combinationSum(int k, int n, int startIndex, int sum) {

        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        //终止条件
        if (startIndex > 9) {
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum+=i;
            combinationSum(k, n, i + 1, sum);
            sum-=i;
            path.removeLast();

        }
    }
}
