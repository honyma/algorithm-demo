package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 找到字符串中所有字母的异位词
 * https://leetcode.cn/problems/VabMRr/description/
 *
 * @author mazehong
 * @date 2024/7/31
 */
public class SlidingWindow_FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();

        int k = 0;
        List<Integer> result = new ArrayList<Integer>();

        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>(8);
        for (int i = 0; i < pChars.length; i++) {
            pMap.put(pChars[i], pMap.getOrDefault(pChars[i], 0) + 1);
        }

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>(8);
        int left = 0;
        //记录窗口中包含p串中字符的种类和个数是否满足，满足则可以缩小窗口
        int noDistinct = 0;
        for (int right = 0; right < sChars.length; right++) {
            char sChar = sChars[right];
            if (pMap.containsKey(sChar)) {
                sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
                if (sMap.get(sChar).equals(pMap.get(sChar))) {
                    noDistinct++;
                }
            }

            while (noDistinct == pMap.size()) {
                //判断排列
                int len = right - left + 1;
                if (len == pChars.length) {
                    result.add(left);
                }
                //缩小窗口
                char lChar = sChars[left];
                if (sMap.containsKey(lChar)) {
                    sMap.put(lChar, sMap.get(lChar) - 1);
                    if (sMap.get(lChar) < pMap.get(lChar)) {
                        noDistinct--;
                    }
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
        //变位词 指字母相同，但排列不同的字符串。

        //示例 1：
        //输入: s = "cbaebabacd", p = "abc"
        //输出: [0,6]
        //解释:
        //起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
        //起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> list = findAnagrams(s, p);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }
}
