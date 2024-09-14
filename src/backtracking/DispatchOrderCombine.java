package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 派单中心派单规则组合问题
 *
 * @author mazehong
 * @date 2024/9/3
 */
public class DispatchOrderCombine {

    /**
     * 例子：[["A1"],["B1", "B2"],["C1"]]
     * [["A1"],["B1", "B2"],["C2","C3"]]
     * [["A2"],["B1", "B2"],["C2","C3"]]
     * [["A1","A2"],["B1"],["C3"]]
     */
    public static List<String> combine(List<List<String>> list) {

        List<String> result = new ArrayList<>();
        doCombine(list, 0, "", result);
        return result;
    }

    /**
     * 使用深搜，也就是回溯, 回溯中一般会用到递归
     */
    public static void doCombine(List<List<String>> list, int startIndex, String curStr, List<String> result) {
        //终止条件
        if (startIndex == list.size()) {
            result.add(curStr);
            return;
        }

        List<String> subList = list.get(startIndex);
        for (String string : subList) {
            doCombine(list, startIndex + 1, curStr + string, result);
        }
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        List<String> sub1 = new ArrayList<>();
        sub1.add("A1");
        sub1.add("A2");
        list.add(sub1);
        List<String> sub2 = new ArrayList<>();
        sub2.add("B1");
        sub2.add("B2");
        list.add(sub2);
        List<String> sub3 = new ArrayList<>();
        sub3.add("C1");
        sub3.add("C2");
        sub3.add("C3");
        list.add(sub3);

        List<String> result = combine(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            System.out.print(",");
        }
    }
}
