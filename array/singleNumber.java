import java.util.Arrays;
import java.util.HashSet;

// 136. 只出现一次的数字
public class Test {

    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};

        Solution solution = new Solution();

        System.out.println(solution.singleNumber2(nums));

    }
}

class Solution {
    // 思路1：排序，检查当前元素和其后面一个元素是否相同
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i+=2) {
            if (i == nums.length - 1) { //此时到达最后一个元素，直接返回
                return nums[nums.length - 1];
            }
            if (nums[i] == nums[i+1]) {
                continue;
            }

            return nums[i];

        }
        return -1; //表示不存在
    }

    //思路2：按位异或  0^a=a  a^a=0 满足交换律
    //因此，依次异或，最后得到的值就是唯一的元素
    public int singleNumber2(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
    
}

