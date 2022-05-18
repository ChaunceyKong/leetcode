

//123. 买卖股票的最佳时机 III
public class Test {
    public static void main(String[] args) {


    }
}

class Solution {
    // 思路：动态规划
    // dp[i][k][0/1]
    // i 表示第i天 k表示最多完成k次交易 0/1表示未持有/持有
    //dp[i][k][0] = max{dp[i-1][k][0], dp[i-1][k][1] + prices[i]}
    //dp[i][k][1] = max{dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]}
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][3][2];

        for (int i = 1; i < prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
                //k=0,都是0，不用算
                if (i == 0) { //初始化
                    dp[i][k][0] = 0; //不管交易多少次，第0天，手上不持有股票，最大收益为0
                    dp[i][k][1] = - prices[i]; //不管交易多少次，第0天，手上持有股票，最大收益为 - prices[0]
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }

        return dp[prices.length-1][2][0];
    }
}

