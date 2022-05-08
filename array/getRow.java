import java.util.*;


//119. 杨辉三角 II

public class Test {
    // 思路：递归实现
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> res = new LinkedList<>();

        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res = generate(res);
        }
        return res;
    }

    public LinkedList<Integer> generate(LinkedList<Integer> preRow) {
        preRow.addFirst(0);
        preRow.addLast(0);
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < preRow.size() - 1; i++) {
            res.add(preRow.get(i) + preRow.get(i+1));
        }

        return res;
    }

    //改进：直接用本函数
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> curRow = new LinkedList<>();
        curRow.add(1); // 头元素
        if (rowIndex == 0) {
            return curRow;
        }
        List<Integer> preRow = getRow1(rowIndex - 1);
        for (int i = 1; i < preRow.size(); i++) {
            curRow.add(preRow.get(i) + preRow.get(i-1));
        }
        curRow.add(1); //尾元素

        return curRow;
    }

}

