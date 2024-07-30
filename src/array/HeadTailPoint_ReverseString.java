package array;

/**
 * 反转字符数组中的字符-反转字符串
 * https://leetcode.cn/problems/reverse-string/description/
 */
public class HeadTailPoint_ReverseString {
    public static void reverseString(char[] s) {
        int head = 0;
        int tail = s.length -1;
        while (head < tail) {
            //涉及到交互移动元素的，一定要用临时变量tmp
            char tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
            head++;
            tail++;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
    }
}
