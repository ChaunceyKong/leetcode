import java.util.ArrayList;
import java.util.List;

//77. 组合
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

        List<List<Integer>> result = solution.combine(4, 2);

        System.out.println(result);


    }
}

class Solution {
    //思路：回溯
    //3层回溯树

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int level = 0;
        backtrack(level, n, k, 1);

        return result;
    }

    public void backtrack(int level, int n, int k, int start) {
        //base case
        if (level == k) {
            result.add(new ArrayList<>(track));
            return;
        }
        if (level < 0 || level > k) {
            return;
        }

        //遍历 dfs
        for (int i = start; i <=n; i++ ) {
            //做选择
            track.add(i);
            level++;
            //回溯
            backtrack(level, n, k, i + 1);
            //撤销选择
            track.remove(Integer.valueOf(i));
            level--;
        }
    }
}