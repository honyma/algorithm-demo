package array;

import java.util.HashMap;

/**
 * 数组两数之和等于目标数
 *
 * @author mazehong
 * @date 2024/7/15
 */
public class TwoNumAdd {

    //遍历右，维护左到 HashMap
    public static int[] sum() {
        int num[] = {2, 3, 5, 6, 9, 7};
        int target = 12;
        HashMap map = new HashMap();
        map.put(num[0], 0);
        for (int i = 1; i < num.length; i++) {
            if (map.containsKey(target - num[i])) {
                return new int[]{i, (int) map.get(target - num[i])};
            }
            map.put(num[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        for (int a : sum()) {
            System.out.println(a);
        }
    }
}
