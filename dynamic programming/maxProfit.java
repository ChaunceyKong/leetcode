import java.util.Arrays;

// 121. 买卖股票的最佳时机
public class Test {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit3(prices));
    }
}

class Solution {
    // 思路：最大利润 ---> 动态规划
    // dp[i][j] 表示第 i 天买入股票，第 j 天卖出股票的利润
    // 1. i >= j: dp[i][j] = -1
    // 2. i < j:
    //   1): prices[i] < prices[j]: prices[j] - prices[i]
    //   2): prices[i] >= prices[j]: 0

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];

        // 初始化dp i<j时，dp[i][j]=-1
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = -1;
            }
        }

        // 遍历所有情况
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    dp[i][j] = prices[j] - prices[i];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        //做选择
        int maxProfit = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                maxProfit = Math.max(maxProfit, dp[i][j]);
            }
        }

        return maxProfit;

    }

    // dp改进：dp[i] 表示第 i 天卖出股票的最大利润
    // 1. prices[i] > prices[j], dp[i] = 0, 其中j <= i
    // 2. prices[i] <= prices[j], dp[i] = prices[i] - prices[j]
    public int maxProfit2(int[] prices) {
        int[] dp = new int[prices.length];

        // 初始化为0
        Arrays.fill(dp, 0);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (prices[i] >= prices[j]) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j]);
                }
            }
        }

        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    //改进：并不需要dp数组存储
    //直接遍历，然后maxProfit = Math(maxProfit, price[i] - price[j])，其中j<=i
    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= i; j++) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
            }
        }

        return maxProfit;
    }

    //改进暴力时间复杂度
    public int maxProfit4(int[] prices) {
        if(prices.length <= 1)
            return 0;

        // min记录之前买入的最小值， max记录最大利润
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}

