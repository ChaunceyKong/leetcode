import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//227.基本计算器 II
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2"));
    }
}

class Solution {
    // 思路：使用栈实现计算器
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigital(c)) {
                num = 10 * num + (c - '0');
            }

            if ((!isDigital(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre = stack.pop();
                        int temp = pre * num;
                        stack.push(temp);
                        break;
                    case '/':
                        pre = stack.pop();
                        temp = pre / num;
                        stack.push(temp);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        //将栈中的元素都加起来
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    // 判断是否是数
    public boolean isDigital(char val) {
        return val >= '0' && val <= '9';
    }
}



