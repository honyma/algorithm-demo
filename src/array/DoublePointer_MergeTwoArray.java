package array;

/**
 * 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 时间复杂度O(m+n)
 * https://leetcode.cn/problems/merge-sorted-array/
 */
public class DoublePointer_MergeTwoArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = 0;
        int second = 0;
        int k = 0;
        int[] sorted = new int[m + n];
        while (first < m && second < n) {
            if (nums1[first] <= nums2[second]) {
                sorted[k++] = nums1[first];
                first++;
            } else {
                sorted[k++] = nums2[second];
                second++;
            }
        }
        while (first < m) {
            sorted[k++] = nums1[first];
            first++;
        }
        while (second < n) {
            sorted[k++] = nums2[second];
            second++;
        }
        //最后在将排序号的sorted数组赋值回nums1数组
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
