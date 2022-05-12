

//80. 删除有序数组中的重复项 II

public class Test {
    public static void main(String[] args) {
        // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a'}};
        String word = "a";

        Solution solution = new Solution();


    }

}

class Solution {
    // 思路：原地删除数组--->双指针-快慢指针
    // 只需要nums[fast] 与 nums[slow-1] 进行比较
    public int removeDuplicates(int[] nums) {
        int fast = 2;
        int slow = 1;
        int len = nums.length;

        while (fast < len) {
            if (nums[slow-1] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }

            fast++;
        }
        return slow+1;
    }
}

