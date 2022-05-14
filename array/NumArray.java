

//303. 区域和检索 - 数组不可变


class NumArray {
    //思路：前缀和

    int[] preNums;
    public NumArray(int[] nums) {
        preNums = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            preNums[i] = nums[i-1] + preNums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preNums[right+1] - preNums[left];
    }
}

