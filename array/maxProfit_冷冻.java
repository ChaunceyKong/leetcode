

//309. 最佳买卖股票时机含冷冻期
public class Test {
    public static void main(String[] args) {


    }
}

class Solution {
    //思路：最大利润 ---> dp
    //dp[i][k][0/1] 表示第i天，最多交易k次，是否持有股票
    //本题 k为无穷，故dp简化为dp[i][0/1]
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        //base case
        dp[0][0] = 0; //第0天没有持有
        dp[0][1] = -prices[0]; //第0天持有

        for (int i = 1; i < prices.length; i++) {
            //base case：保证dp[i-2]有效
            if (i - 2 < 0) {
                dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
                continue;
            }
            //第i天未持有有两种情况：
            //  1.第i-1天持有，第i天卖出
            //  2.第i-1天未持有，第i天继续未持有
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            //第i天持有有两种情况：
            //  1.第i-2天卖出，第i天持有
            //  2.第i-1天持有，第i天继续持有
            dp[i][1] = Math.max(dp[i-2][0] - prices[i], dp[i-1][1]);
        }


        return dp[prices.length - 1][0];
    }
}

