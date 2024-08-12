package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前K个高频元素-二叉堆
 * https://leetcode.cn/problems/top-k-frequent-elements/description/
 *
 * @author mazehong
 * @date 2024/8/8
 */
public class BinaryHeap_TopKFrequent {

    /**
     * 使用小顶堆
     */
    public static int[] topKFrequent(int[] nums, int k) {
        //计算数组元素出现的频率，可以用hashmap
        //这里重点就是解决对频率value值进行小顶堆排序后，怎么获取到对应的key
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((pair1, pair2) -> (pair1[1] - pair2[1]));
        int[] res = new int[k];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
            while (queue.size() > k) {
                //把最小的出队
                queue.poll();
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            res[index] = queue.poll()[0];
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] result = topKFrequent(nums, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "->");
        }
    }
}
