package array;

/**
 * 二分查找 (左闭右开) [1,10)
 * 本质还是用左右（首尾left、right）指针的问题
 * <p>
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author mazehong
 * @date 2024/7/23
 */
public class BinarySearch_SearchRange {

    //在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        //如果有一个目标元素出现，一定会有最后一个
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                //往右继续找最后一个，直到left和right相等退出
                left = mid + 1;
            } else {
                //nums[mid] < target
                left = mid + 1;
            }
        }

        return left - 1;//这里由于用的是左闭右开原则，所以不包含最后一个数组长度length的元素，所以要减一
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//这里遵循的是左闭右开原则
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                //继续查找左边第一个，等到两个相等就退出
                right = mid;
            } else {
                //nums[mid] < target
                left = mid + 1;
            }
        }
        //要判断数组越界问题，因为左闭右开不包含数组长度最后一个
        //并且左边第一个元素值要等于目标值
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int[] a = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        System.out.println(searchRange(a, 4));*/

        /*int[] a = new int[]{1, 3};
        System.out.println(findLastPosition(a, 3));*/

        /*int[] b = new int[]{1, 2, 3, 5, 7, 9};
        System.out.println(searchRange(b, 6));*/

        int[] c = new int[]{1, 1, 1};
        System.out.println(findFirstPosition(c, 3));
    }
}
