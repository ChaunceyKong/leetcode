import java.util.*;
//16. 最接近的三数之和
public class Test {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}

class Solution {
    //思路：
    //1.首先对数组进行排序
    //2.固定一个元素，后面首尾指针移动，直到三数之和等于或接近
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nearSum = -666; //随意的一个数
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    l++;
                }
                else if (sum > target) {
                    r--;
                }
                else {
                    return target;
                }
                if (Math.abs(nearSum-target) > Math.abs(sum-target)) {
                    nearSum = sum;
                }
            }
        }
        return nearSum;
    }
}