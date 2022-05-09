import java.util.*;


//66. 加一

public class Test {
    // 思路：从末位相加，逢10进一
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len + 1];
        int carry = (digits[len-1] + 1) / 10;
        res[len] = (digits[len-1] + 1) % 10;
        for (int i = len - 1 ; i >= 0; i--) {
            if (i == 0) {
                res[i] = carry;
            }else {
                res[i] = digits[i - 1] + carry;
            }
            if (res[i] / 10 == 1) { // 逢10进1
                res[i] = 0;
                carry = 1;
            }else {
                carry = 0;
            }

        }
        return res[0] == 0? Arrays.copyOfRange(res,1,len):res;
    }

    //改进
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        //此时digits全为0，需要手动补一位进位
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}

