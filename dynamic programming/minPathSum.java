import java.util.Arrays;
//64. 最小路径和
public class Test {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));

    }
}

class Solution {
    //思路：回溯--->怎么找最小？--->动态规划
    //自底向上动态规划，无需递归，只需要dp数组
    //dp[][] 表示当前(i,j)位置的最小路径和，即dp[i][j]=上面或者左边最小的一条路径+当前值
    //状态转移dp[i][j]=(1)dp[i][j-1] + grid[i][j]
    //              =(2)dp[i-1][j] + grid[i][j]

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        //base case
        //初始化第一行
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[0][i] += grid[0][j];
            }
        }
        //初始化第一列
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][0] += grid[j][0];
            }
        }

        //状态转移
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        //选择
        return dp[grid.length-1][grid[0].length-1];
    }

    //方法2：自顶向下动态规划：备忘录+递归
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //构造备忘录，初始值全部设为-1
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(grid, memo, m - 1, n - 1);
    }

    //memo[i][j]记录了从i走到j的最小路径和
    //dp函数就是计算从i走到j最小路径和
    public int dp(int[][] grid, int[][] memo, int i, int j) {
        //base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        //避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = Math.min(
                dp(grid, memo, i - 1, j),
                dp(grid, memo, i, j - 1)
        ) + grid[i][j];

        return memo[i][j];
    }
}