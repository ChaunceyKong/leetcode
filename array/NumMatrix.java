

//304. 二维区域和检索 - 矩阵不可变

//思路：前缀和
class NumMatrix {

    int[][] preNum; //表示（0，0，i-1，j-1 ）子矩阵的和
    public NumMatrix(int[][] matrix) {
        preNum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                preNum[i][j] = preNum[i-1][j] + preNum[i][j-1] - preNum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNum[row2+1][col2+1] - preNum[row1][col2+1] - preNum[row2+1][col1] + preNum[row1][col1];
    }
}

