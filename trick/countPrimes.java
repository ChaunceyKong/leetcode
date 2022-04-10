
import java.util.Arrays;

// 204. 计数质数
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.countPrimes2(499979));
    }
}

class Solution {
    // 思路1：暴力解法  超时
    // 外层循环依次遍历每一个值，内层循环依次取余小于 i 的值求其因子
    public int countPrimes(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }

        int count = 0;
        boolean flag = false;

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
            flag = false;
        }
        return count;
    }

    // 思路2：筛选法
    // 排除掉所有 i 倍数，剩下的就是素数
    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        //对正整数 n ，如果用 2 到 √n 之间(包含边界)的所有整数去相除，均无法整除，则 n 为质数。
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < n; j += i) { // 排除掉所有i的倍数
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
