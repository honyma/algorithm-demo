package array;

/**
 * 有序数组元素求平方后，排序
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 *
 * @author mazehong
 * @date 2024/7/24
 */
public class ArraySquaresSort {

    //用头和尾双指针法
    //数组求平方后（无论正数还是负数），最大元素肯定是在两边
    public static int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int head = 0;
        int tail = nums.length - 1;
        int k = tail;
        while (head <= tail) { //注意这里，要小于等于
            int headSqu = nums[head] * nums[head];
            int tailSqu = nums[tail] * nums[tail];
            if (headSqu < tailSqu) {
                res[k--] = tailSqu;
                tail--;
            } else {
                res[k--] = headSqu;
                head++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = new int[]{-4, -1, 0, 3, 10};
        int b[] = new int[]{-7, -3, 2, 3, 11};
        int res[] = sortedSquares(b);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }
}
