import java.util.Arrays;

// 122. 买卖股票的最佳时机 II
public class Test {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

class Solution {
    // 思路：最大利润 ---> 动态规划
    // 1. dp[i][0] 表示到第 i 天并未持有股票的最大利润，dp[i][1] 表示到第 i 天持有股票最大利润
    // 2. dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
    //    1) dp[i-1][0] 表示前一天未持有股票的最大利润
    //    2) dp[i-1][1]+prices[i] 表示前一天持有股票的利润+卖出第i天股票的价钱
    // 3.dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
    //    1) dp[i-1][i] 表示前一天持有股票的最大利润
    //    2) dp[i-1][0]-prices[i] 表示前一天未持有股票的最大利润-购买第i天股票的价钱
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0]; //表示购买了一直股票

        // 遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}

