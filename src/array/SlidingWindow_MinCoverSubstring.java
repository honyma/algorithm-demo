package array;

import java.util.HashMap;

/**
 * 最小覆盖子串（大串包含小串问题）
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * https://leetcode.cn/problems/minimum-window-substring/description/
 */
public class SlidingWindow_MinCoverSubstring {
    public static String minWindowSubstring(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        //解题方法：
        //1.滑动窗口
        //2.窗口左移动条件：等于t字符串中包含字符的个数（要解决s字符串中重复元素的问题），用一个计数变量解决
        //3.窗口内字符的个数

        int sLen = s.length();
        int tLen = t.length();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        HashMap<Character, Integer> winMap = new HashMap<>(8);
        HashMap<Character, Integer> tMap = new HashMap<>(8);
        for (int i = 0; i < tChars.length; i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }

        int noDistinct = 0;
        int minLen = Integer.MAX_VALUE;

        int begin = 0;
        int left = 0;
        for (int right = 0; right < sLen; right++) {
            if (tMap.containsKey(sChars[right])) {
                winMap.put(sChars[right], winMap.getOrDefault(sChars[right], 0) + 1);
                if (tMap.get(sChars[right]).equals(winMap.get(sChars[right]))) {
                    noDistinct++;
                }
            }

            while (noDistinct == tMap.size()) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    begin = left;
                }

                if (winMap.containsKey(sChars[left])) {
                    winMap.put(sChars[left], winMap.get(sChars[left]) - 1);
                    if (winMap.get(sChars[left]) < tMap.get(sChars[left])) {
                        noDistinct--;
                    }
                }
                left++;
            }
        }
        //最后要判断一些，解决 相同字符串的子串问题
        return minLen == Integer.MAX_VALUE ? "" : s.substring(begin, begin + minLen);
    }

    public static void main(String[] args) {
        //String s = "ADBABECODEBANC";
        //String t = "ABC";
        String s = "aa";
        String t = "aa";

        System.out.println(minWindowSubstring(s, t));
    }
}
