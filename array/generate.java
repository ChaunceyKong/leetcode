import java.util.*;


//118. 杨辉三角

public class Test {
    // 思路：暴力解法
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();

        List<Integer> pre = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new LinkedList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int num1 = pre.get(j-1);
                int num2 = pre.get(j);
                row.add(num1 + num2);
            }
            if (i != 0) {
                row.add(1);
            }
            pre = new LinkedList(row);
            res.add(new LinkedList(row));
        }
        return res;
    }
    
}

