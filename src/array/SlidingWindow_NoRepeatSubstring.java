package array;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class SlidingWindow_NoRepeatSubstring {
    public static int lengthOfLongestSubstring(String s) {
        //思想很重要
        //1.判断没有重复字符，需要使用哈希表
        //2.最长子串，需要使用到滑动窗口（滑动窗口思想-起始位置为窗口左指针，结束位置为窗口右指针-结束位置就是字符串的长度）
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(8);
        char[] chars = s.toCharArray();
        //子串最大长度
        int maxLex = 0;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            //窗口判断无重复字符,（判断前要先把元素加进去，这一点很重要）
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            //这里的while条件判断很重要，统计判断哈希表中没有重复元素
            while (map.get(chars[right]) > 1) {
                //缩小窗口
                //并且哈希表中对应的值要减一
                map.put(chars[left], map.get(chars[left]) - 1);
                left++;
            }
            maxLex = Math.max(maxLex, right - left + 1);
        }
        return maxLex;
    }

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s ="bbbbb";
        String s ="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
