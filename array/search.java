import java.util.*;


//33. 搜索旋转排序数组

public class Test {
    // 思路1：暴力解法
    public int search(int[] nums, int target) {
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    // 思路2：二分
    // 旋转数组从中间划分，肯定有一边是升序的
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < nums[right]) { //右边有序
                if (target > nums[mid] && target <= nums[right]) { //目标值在右边
                    left = mid + 1;
                } else { // 目标值在左边
                    right = mid - 1;
                }
            } else { //左边有序
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


}

