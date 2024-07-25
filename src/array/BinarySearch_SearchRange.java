package array;

/**
 * 二分查找 (左闭右开) [1,10)
 * 本质还是用左右（首尾）指针的问题
 * <p>
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author mazehong
 * @date 2024/7/23
 */
public class BinarySearch_SearchRange {

    //在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int left = 0;
        int right = nums.length;
        int count = 0; //定义计数很重要，下面会判断在没找到目标值的情况下，直接返回
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                count++;
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (count == 0) {
            return result;
        }
        for (int i = mid; i >= left; i--) {
            if (i == 0) {
                result[0] = i;
                break;
            }
            if (nums[i] != target) {
                result[0] = i + 1;
                break;
            }
        }
        for (int i = mid; i <= right; i++) {
            if (nums[i] != target) {
                result[1] = i - 1;
                break;
            }
            if (i == nums.length - 1) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*int[] a = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        System.out.println(searchRange(a, 4));*/

        int[] a = new int[]{1,3};
        System.out.println(searchRange(a, 1));


        /*int[] b = new int[]{1, 2, 3, 5, 7, 9};
        System.out.println(searchRange(b, 6));*/

        /*int[] c = new int[]{1};
        System.out.println(searchRange(c, 1));*/
    }
}
