package array;

/**
 * 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 *
 * @author mazehong
 * @date 2024/7/26
 */
public class FastSlowPoint_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast-1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2};
        int result = removeDuplicates(a);
        System.out.println(result);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }

        /*int[] b = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(b);
        System.out.println(result);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ",");
        }*/
    }
}
