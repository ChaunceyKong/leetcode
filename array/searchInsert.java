import java.util.*;


//35. 搜索插入位置

public class Test {
    // 思路：二分查找
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) { // 左边
                right = mid - 1;
            } else if (target > nums[mid]) { // 右边
                left = mid + 1;
            } else {
                // return mid;
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};

        System.out.println(searchInsert(nums, 2));
    }

}

