package array;

/**
 * 快慢指针
 * https://leetcode.cn/problems/remove-element/description/
 *
 * @author mazehong
 * @date 2024/7/23
 */
public class FastSlowPoint_RemoveTargetElement {

    //删除元素后，并且要把数组元素往前移动。因为对数组删除元素后需要移动其他元素
    public static int removeTargetElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeTargetElement(a, 2));
    }
}
