
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
    }
}

//316. 去除重复字母
class Solution {
    //思路：
    //1. 去重：inStack[] 保证栈中元素不存在重复元素
    //2. 相对位置不变：栈的顺序结构可以保证
    //3. 最小字典序：单调栈，配合计数数组count[]
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        int[] count = new int[256]; //记录字符数量
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] inStack = new boolean[256]; //记录元素是否在栈中
        for (char c : s.toCharArray()) {
            //每遍历一个元素，就--
            count[c]--;
            if (inStack[c]) { // 如果栈中还存在，则跳过
                continue;
            }

            //栈不为空，且栈顶元素字典序大于目前元素
            while (!stack.isEmpty() && stack.peek() > c) {

                if (count[stack.peek()] == 0) { // 说明后面没有元素
                    break;
                }
                //后面还有元素，可以弹出栈
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        //此时栈中元素就是符合条件的元素
        StringBuilder sb = new StringBuilder();
        //注意：不能使用for，因为栈的大小随时变化！！！
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}