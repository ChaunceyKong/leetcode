import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


//241. 为运算表达式设计优先级

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路：分治思想(递归)
    //x op y---> x = x' op y' , y = x'' op y''...

    HashMap<String, List<Integer>> memo = new HashMap<>(); //备忘录剪枝

    public List<Integer> diffWaysToCompute(String expression) {
        // 避免重复计算
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 分
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                // 治
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            res.add(a + b);
                        } else if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        }
                    }
                }

            }
        }
        //base case
        if (res.isEmpty()) { //如果res为空，说明该表达式就是一个数，直接加入res列表
            res.add(Integer.valueOf(expression));
        }
        // 将结果添加进备忘录
        memo.put(expression, res);

        return res;
    }




}



