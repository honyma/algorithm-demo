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
public class BinarySearch_CountTarget {

    //某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。
    //这道题重点就是数组是递增有顺序的，并且如果出现跟目标相同的元素，是会紧密排列在一起的
    //所以重点就是找出左边第一个等于target的下表，再找出右边第一个大于target的下标，然后(rightIdx - leftIdx +1)就是出现的次数
    public static int countTarget(int[] scores, int target) {

        /*int leftIdx = binarySearch(scores, target, true);
        int rightIdx = binarySearch(scores, target, false);
        if (rightIdx == 0 || leftIdx == 0) {
            return 0;
        }
        return (rightIdx - leftIdx) + 1;*/
        return countTarget2(scores, target);
    }

    public static int countTarget2(int[] scores, int target) {

        int left = 0;
        int right = scores.length;
        int count = 0;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (scores[mid] == target) {
                count++;
                break;
            } else if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (count == 0) {
            return 0;
        }
        for (int i = mid + 1; i < right; i++) {
            if (scores[i] == target) {
                count+=1;
            } else {
                break;
            }
        }
        for (int i = mid -1; i >= left; i--) {
            if (scores[i] == target) {
                count+=1;
            } else {
                break;
            }
        }
        return count;
    }

    //如果lower为true, 说明找的是左边第一个等于target的下标
    //如果lower为false, 说明找的是右边第一个大于target的下标，然后要下标再减一
    /*public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length;
        int index = 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if (mid == 0) {
                    index =1;
                    break;
                }
                if (lower) {
                    if (nums[mid - 1] < target) {
                        index = mid;
                        break;
                    }
                    if (nums[mid - 1] == target) {
                        right = mid;
                    }
                } else {
                    if (nums[mid + 1] > target) {
                        index = mid;
                        break;
                    }
                    if (nums[mid + 1] == target) {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }*/

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        System.out.println(countTarget2(a, 4));

        /*int[] b = new int[]{1, 2, 3, 5, 7, 9};
        System.out.println(countTarget2(b, 6));*/

        /*int[] c = new int[]{1};
        System.out.println(countTarget2(c, 1));*/
    }
}
