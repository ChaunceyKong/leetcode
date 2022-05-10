import java.util.*;


//75. 颜色分类

public class Test {
    // 思路：排序
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] >= pivot) {
                    high--;
                }
                nums[low] = nums[high];

                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                nums[high] = nums[low];
            }

            nums[low] = pivot;
            quickSort(nums,start,low);
            quickSort(nums,low+1,end);
        }
    }

}

