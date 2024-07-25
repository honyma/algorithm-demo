package array;

/**
 * 生成螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 *
 * @author mazehong
 * @date 2024/7/23
 */
public class GenerateMatrix {

    //给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
    public static int[][] generateMatrix(int n) {

    }

    public static void main(String[] args) {
        int a[][] = generateMatrix(4);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
