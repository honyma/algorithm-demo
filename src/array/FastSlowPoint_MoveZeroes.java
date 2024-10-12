package array;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 你能尽量减少完成的操作次数吗？
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class FastSlowPoint_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        //用两个前后指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                //涉及到交换移动位置的，一定要用到中间变量tmp
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        //输入: nums = [0,1,0,3,12]
        //输出: [1,3,12,0,0]
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
    }
}
