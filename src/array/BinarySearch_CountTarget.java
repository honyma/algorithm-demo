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
    //所以重点就是找出左边第一个等于target的下表，再找出右边第一个等于target的下标，然后(rightIdx - leftIdx +1)就是出现的次数
    public static int countTarget(int[] scores, int target) {
        if (scores.length == 0) {
            return 0;
        }
        int firstPosition = findFirstPosition(scores, target);
        if (firstPosition == -1) {
            return 0;
        }
        //如果有一个目标元素出现，一定会有最后一个
        int lastPosition = findLastPosition(scores, target);
        return lastPosition - firstPosition + 1;
        //return countTarget2(scores, target);
    }

    private static int findLastPosition(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (scores[mid] > target) {
                right = mid;
            } else if (scores[mid] == target) {
                //如果相等，继续往右查找最后一个元素，直到left=right退出
                left = mid + 1;
            } else {
                //scores[mid] < target
                left = mid + 1;
            }
        }
        return left - 1; //这里由于用的是左闭右开原则，所以不包含最后一个数组长度length的元素，所以要减一
    }

    private static int findFirstPosition(int[] scores, int target) {
        int left = 0;
        int right = scores.length;//这里遵循的是左闭右开原则
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (scores[mid] > target) {
                right = mid;
            } else if (scores[mid] == target) {
                //继续往左边查找第一个等于target值，直到left = right退出
                right = mid;
            } else {
                //scores[mid] < target
                left = mid + 1;
            }
        }
        //要判断数组越界问题，因为左闭右开不包含数组长度最后一个
        //并且左边第一个元素值要等于目标值
        if (left < scores.length && scores[left] == target) {
            return left;
        }
        return -1;
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
                count += 1;
            } else {
                break;//这里要退出，这一步很关键
            }
        }
        for (int i = mid - 1; i >= left; i--) {
            if (scores[i] == target) {
                count += 1;
            } else {
                break; //这里要退出，这一步很关键
            }
        }
        return count;
    }

    //如果lower为true, 说明找的是左边第一个等于target的下标
    //如果lower为false, 说明找的是右边第一个等于target的下标


    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        System.out.println(countTarget2(a, 4));

        /*int[] b = new int[]{1, 2, 3, 5, 7, 9};
        System.out.println(countTarget2(b, 6));*/

        /*int[] c = new int[]{1};
        System.out.println(countTarget2(c, 1));*/
    }
}
