import java.util.*;


//120. 三角形最小路径和

public class Test {
    // 思路：动态规划
    // dp[i][j] 表示triangle列表 第i行 第j列元素位置的最小路径和
    // dp[i][j]=min{dp[i-1][j].dp[i-1][j-1]}+triangle[i][j]
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        //初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);

        //遍历
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) +
                            triangle.get(i).get(j);
                }
            }
        }
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n-1][i]);
        }
        return minPathSum;
    }
}

