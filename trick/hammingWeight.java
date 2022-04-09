

// 191. 位1的个数
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    // 思路1：右移32次
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //注意：Java >>（算数右移） 和 >>>（逻辑右移）的区别
        // >>：舍弃最低位，高位用符号位填补
        // >>>：舍弃最低位，高位用0填补
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }

    // 思路2：n&(n-1) 用来消除n二进制数最后一个1
    public int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
