
//213. 打家劫舍 II
class Solution {
    //思路：动态规划
    //环形排列房间 变成 两个单排排列房间：0~n-1、1~n
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[nums.length + 1];

        int maxMoney = 0;
        //初始化dp
        //1.打劫0号，不打劫length-1号
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        maxMoney = dp[nums.length - 1]; //取倒数第二个房屋，因为打劫了第一个房屋，不打劫最后一个房屋

        //2.不打劫0号，打劫length-1号
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        maxMoney = Math.max(maxMoney,dp[nums.length]);
        return maxMoney;
    }

    //优化
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }

        int maxMoney = 0;
        //打劫0~n-1号，取数组索引0~n-2
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        maxMoney = dp[nums.length - 2];

        //打劫1~n号，取数组索引1~n-1
        dp[0] = nums[1];
        dp[1] = Math.max(dp[0], nums[2]);

        for (int i = 2; i < nums.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i+1]);
        }

        maxMoney = Math.max(maxMoney,dp[nums.length - 2]);
        return maxMoney;
    }
}


