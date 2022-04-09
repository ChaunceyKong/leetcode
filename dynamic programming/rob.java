import java.util.Arrays;

// 198. 打家劫舍
public class Test {

    public static void main(String[] args) {

    }
}

class Solution {
    // 思路：最高金额 ---> 动态规划
    //dp[i] 表示i这个位置的最大值，当 i==nums.length-1，此时偷盗结束，dp[nums.length-1]表示最大值
    //dp[i] = max{dp[i-1],dp[i-2]+nums[i]}
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        //base case
        dp[0] = nums[0];

        //状态转移
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[0], nums[i]);
                continue;
            }

            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        //做选择
        return dp[nums.length-1];
    }
}
