import java.util.*;


//268. 丢失的数字

public class Test {
    // 思路：暴力解法
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = -1;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if ((nums[i] - i) != 0) {
                res = i;
                break;
            }
        }

        return res == -1 ? len : res;
    }

    // 思路2：利用异或：a^a=0  0^a=a
    // 异或满足交换律，当nums[i]与索引依次异或后，最后res的值就是剩下缺失的元素
    public int missingNumber(int[] nums) {
        int n = nums.length; //第n位索引
        int res = 0;

        res ^= n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;


    }

}

