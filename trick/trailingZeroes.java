

// 172. 阶乘后的零
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    // 思路：暴力解法 问题：int表示不了很大的数
    // 技巧：末尾0肯定是*10造成的，而10只能分解为2*5，而2肯定多余5，因此只要找有多少个5.
    // 最后答案就是：n/5 + n/25 + n/125 + ...
    // 由于分母可能溢出，因此在计算后一的时候更新 n=n/5，则每一次只需要计算n/5
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
