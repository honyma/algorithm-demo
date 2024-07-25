package array;

/**
 * 最小子数组长度
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * @author mazehong
 * @date 2024/7/24
 */
public class MinSubArrayLen {

    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        for (int i = 0; i < nums.length ; i++) {

        }
    }

    public static void main(String[] args) {
        int []a = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, a));
    }
}
