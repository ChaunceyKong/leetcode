import java.util.*;


//31. 下一个排列

public class Test {
    // 字典序：从第一位开始按位比较
    // 思路：暴力解法
    // 后面尽可能小的大数与尽可能靠右的小数交换,交换后重新升序排列交换索引位置后面的所有元素

    public static void nextPermutation(int[] nums) {

        int startIdx = 0, endIdx = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {

            if (nums[i] > nums[i-1]) { //此时 [i,end] 元素为降序
                // 在[i,end]中，寻找最小的大数
                startIdx = i - 1;
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[startIdx]) {
                        int temp = nums[j];
                        nums[j] = nums[startIdx];
                        nums[startIdx] = temp;
                        Arrays.sort(nums, startIdx + 1, endIdx);
                        return;
                    }
                }
            }
        }


        Arrays.sort(nums, startIdx, endIdx);
        return;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1};//{4,2,0,2,3,2,0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

