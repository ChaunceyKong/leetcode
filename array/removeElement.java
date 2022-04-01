//27. 移除元素
public class Test {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, 3));
    }
}

class Solution {
    //思路：双指针
    //1.右指针r依次遍历，搜索非val值
    //2.若nums[r]!=val，则nums[l]==nums[r]，左指针l++；否则跳过nums[r]
    public int removeElement(int[] nums, int val) {
        int len = 0;

        for (int r = 0, l = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            len = l;
        }
        return len;
    }
}
