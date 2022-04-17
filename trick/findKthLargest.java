import java.util.Arrays;

//215. 数组中的第K个最大元素
class Solution {
    // 思路：数组降序，取k索引，或者升序，取length-k个元素
    // 考察排序算法，不能使用内置排序函数
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length-k];
    }

    //快速排序
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;
        int pivot = nums[start];

        while (low < high) {
            //从右边开始寻找比pivot小的数
            while (low < high && pivot <= nums[high]) {
                high--;
            }
            //此时high对应的数 nums[high] < pivot
            nums[low] = nums[high];
            //从左边开始寻找比pivot大的数
            while (low < high && pivot >= nums[low]) {
                low++;
            }
            //此时low对应的数 nums[low] > pivot
            nums[high] = nums[low];
        }
        //此时low==high
        nums[low] = pivot;
        //左边递归
        quickSort(nums,start,low);
        //右边递归
        quickSort(nums,low+1,end);
    }

}


