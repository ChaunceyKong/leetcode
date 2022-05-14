

//283. 移动零

public class Test {
    public static void main(String[] args) {
        // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a'}};
        String word = "a";

        Solution solution = new Solution();


    }

}

class Solution {
    // 思路：原地修改数组 ---> 双指针
    // 1.fast指针移动，当该位置元素不是0时，赋给slow
    // 2.最后记录0的个数，将剩余位置全部置0
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 改进：一次遍历
    // 循环不变量： 在每一次循环前，slow 的左边全部都是不等于0的
    // 1.起始slow为0，明显满足
    // 2.此后每一次循环中，若nums[fast =] = 0，则j保持不变，满足；若nums[fast =] != 0，交换后slow增一，仍然满足
    // 3.这就保证了最后结果的正确性。
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) { //如果fast对应元素 != 0，就交换
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }

}

