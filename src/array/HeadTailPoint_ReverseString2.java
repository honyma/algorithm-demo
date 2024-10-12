package array;

/**
 * 反转k个字符串
 * https://leetcode.cn/problems/reverse-string-ii/
 *
 * @author mazehong
 * @date 2024/8/2
 */
public class HeadTailPoint_ReverseString2 {
    public static String reverseStr(String s, int k) {
        char []sChar = s.toCharArray();
        for(int i=0; i<sChar.length; i+=(2*k)) {
            //遵循左闭右闭原则
            if(i+k <= sChar.length) {
                //遵循左闭右闭原则
                reverseChar(sChar, i, i+k-1);
            } else {
                //遵循左闭右闭原则
                reverseChar(sChar, i, sChar.length-1);
            }
        }

        return new String(sChar);
    }

    public static char[] reverseChar(char []chars, int left, int right) {
        while(left < right) {
            char tmp = chars[left];
            chars[left]=chars[right];
            chars[right]=tmp;
            left++;
            right--;
        }

        return chars;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
    }
}
