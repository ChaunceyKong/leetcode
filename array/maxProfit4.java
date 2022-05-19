

//188. 买卖股票的最佳时机 IV
public class Test {
    public static void main(String[] args) {


    }
}

class Solution {
    //思路：最大利润 ---> dp
    //dp[i][k][0/1] 表示第i天，最多交易k次，是否持有股票
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][k+1][2];

        // k = 0 时的 base case
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            for(int j = 1; j < k + 1; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }
}

