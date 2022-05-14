

//300. 最长递增子序列


import java.util.Arrays;

class Solution {
    // 思路：最长 ---> 动态规划
    // dp[i] 表示：i结尾的子序列最长长度,即前面比nums[i]小的数的个数

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp,1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}

