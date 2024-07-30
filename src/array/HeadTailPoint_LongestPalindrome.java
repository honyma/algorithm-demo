package array;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class HeadTailPoint_LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxLen = 1;
        int startIndex = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            //这里j的起始值很重要，一定是要在i+1之后，这样才能两个for循环暴力解全部覆盖到
            for (int j = i + 1; j < chars.length; j++) {
                int len = j - i + 1;
                if (len > maxLen && judgePalindrome(chars, i, j)) {
                    maxLen = Math.max(maxLen, len);
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    public static boolean judgePalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        //String s = "cbbd";
        //System.out.println(s.substring(4,5));
        System.out.println(longestPalindrome(s));
    }
}
