
//231. 2 的幂
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPowerOfTwo(3));
    }
}

class Solution {
    // 思路1：转换为double类型，求余数
    public boolean isPowerOfTwo(int n) {
        double num = (double) n;
        while (num >= 2) {
            num /= 2.0;
        }

        return num == 1;
    }

    // 思路2：位运算，
    // 2的幂的数，其二进制只有一个1
    // n&(n-1)，即将n的最低为1变为0
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}



