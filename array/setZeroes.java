import java.lang.reflect.Array;
import java.util.*;


//73. 矩阵置零

public class Test {
    // 思路：暴力解法
    // 1.先搜索矩阵中元素为0的行和列
    // 2.将行和列的元素置为0
    // 空间复杂度O(m+n)
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new LinkedList<>(); //保存行
        List<Integer> col = new LinkedList<>(); //保存列

        int m = matrix.length;
        int n = matrix[0].length;

        // 搜索矩阵中0元素的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        // 对矩阵行和列置0
        for (int i = 0; i < row.size(); i++) { //行置0
            Arrays.fill(matrix[row.get(i)],0);
        }
        for (int j = 0; j < col.size(); j++) { //列置0
            for (int i = 0; i < m; i++) {
                matrix[i][col.get(j)] = 0;
            }
        }
    }

    // 思路2：将矩阵的第一行和第一列作为标志位
    // 空间复杂度O(1)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 首先判断矩阵的第一行和第一列中是否有0
        boolean rowContainsZero = false;
        boolean colContainsZero = false;
        for (int i = 0; i < n; i++) { //判断第一行是否含有0
            if (matrix[0][i] == 0) {
                rowContainsZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) { //判断第一列是否含有0
            if (matrix[i][0] == 0) {
                colContainsZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; //列标志位
                    matrix[i][0] = 0; //行标志位
                }
            }
        }

        //开始置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowContainsZero) { //第一行置为0
            Arrays.fill(matrix[0],0);
        }
        if (colContainsZero) { //第一列置为0
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}

