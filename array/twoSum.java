

// 167. 两数之和 II - 输入有序数组
public class Test {

    public static void main(String[] args) {

    }
}

class Solution {
    // 思路：有序 --> 双指针
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];

            if (sum == target) {
                return new int[]{lo + 1, hi + 1};
            }

            if (sum < target) {
                lo += 1;
            } else if (sum > target) {
                hi -= 1;
            }
        }

        return new int[]{-1, -1};
    }
}
