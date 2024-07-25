package array;

/**
 * 二分查找 (左闭右开) [1,10)
 *
 * @author mazehong
 * @date 2024/7/23
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(a, 9));

        int[] b = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(b, 2));
    }
}
