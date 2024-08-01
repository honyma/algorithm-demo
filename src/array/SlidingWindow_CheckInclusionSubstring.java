package array;

import java.util.HashMap;

/**
 * 子字符串排列
 * https://leetcode.cn/problems/permutation-in-string/
 *
 * @author mazehong
 * @date 2024/7/31
 */
public class SlidingWindow_CheckInclusionSubstring {
    public static boolean checkInclusion(String s1, String s2) {
        //解决步骤点：
        //1.滑动窗口-大串包含小串问题
        //2.字符串的排列，必须窗口长度等于字符串长度
        //3.窗口左移动条件：窗口长度等于字符串长度并且 子字符串的个数等于窗口中出现字符的个数
        //4.需要知道窗口中字符的个数，才能对noDistinct进行统计加加

        char[] pChars = s1.toCharArray();
        char[] tChars = s2.toCharArray();

        HashMap<Character, Integer> pMap = new HashMap<>(8);
        for (int i = 0; i < pChars.length; i++) {
            pMap.put(pChars[i], pMap.getOrDefault(pChars[i], 0) + 1);
        }

        //noDistinct用来记录 窗口中包含了 "覆盖字符串t" 的字符种类和个数
        //记录窗口中包含p串中字符的种类和个数是否满足，满足则可以缩小窗口
        int noDistinct = 0;

        HashMap<Character, Integer> tMap = new HashMap<>(8);
        int left = 0;
        for (int right = 0; right < tChars.length; right++) {
            char rc = tChars[right];
            if (pMap.containsKey(rc)) {
                tMap.put(rc, tMap.getOrDefault(rc, 0) + 1);
                //计算字符的种类
                if (tMap.get(rc).equals(pMap.get(rc))) {
                    noDistinct++;
                }
            }

            //如果窗口内的字符种类够了
            while (noDistinct == pMap.size()) {
                int len = right - left + 1;
                //判断排列
                if (pChars.length == len) {
                    return true;
                }

                //如果长度不相等，缩小窗口
                char lc = tChars[left];
                if (pMap.containsKey(lc)) {
                    tMap.put(lc, tMap.get(lc) - 1);
                    if (tMap.get(lc) < pMap.get(lc)) {
                        noDistinct--;
                    }
                }
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
        //换句话说，s1 的排列之一是 s2 的 子串 。
        String s1 = "aab";
        String s2 = "eidbaaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}
