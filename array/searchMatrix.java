import java.util.*;


//74. 搜索二维矩阵

public class Test {
    // 思路1：暴力解法
    // 先比较每行的第一个元素 和 最后一个元素，锁定在一行中
    // 依次比较行中元素
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n-1]) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //思路2：坐标轴法
    //以左下角为坐标轴原点，若 target < (i,j) 则向上移动一格
    //若 target > (i,j) 则向右移动一格
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j <= matrix[0].length - 1) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

    //改进：一次二分
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target > matrix[mid / n][mid % n]) {
                left = mid + 1;
            } else if (target < matrix[mid / n][mid % n]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}

