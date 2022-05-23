
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

//344. 反转字符串
class Solution {
    //思路：双指针
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}