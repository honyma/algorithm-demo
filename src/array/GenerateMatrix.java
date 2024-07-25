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
    //做这个题的时候，最重要的是边界处理问题，坚持 左闭右开 的原则，开的最后一个元素不处理
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0; //X轴
        int startY = 0; //Y轴
        int count = 1; //计数
        int loop = 1; //执行的圈数

        int i; //注意：执行过程中i是会变的
        int j; //注意：执行过程中j是会变的
        int offset = 1; //边界偏移量
        while (n / 2 >= loop) {
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            //此时到这里i和j已经是对角最大了
            //for循环结束后，j会到零
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            loop++;
            offset++;
        }
        //如果是奇数
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }

    public static void main(String[] args) {
        int a[][] = generateMatrix(6);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
