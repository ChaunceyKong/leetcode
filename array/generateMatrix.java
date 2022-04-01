import java.util.Arrays;
//59. 螺旋矩阵 II
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = solution.generateMatrix(3);

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}

class Solution {
    //思路：
    //设置上下左右4个边界
    //按顺序依次填充值
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >=top; i--) {
                matrix[i][left] = num++;
            }
            left++;

        }

        return matrix;
    }
}