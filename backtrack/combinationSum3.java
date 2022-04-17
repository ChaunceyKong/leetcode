import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
    }
}
//215. 数组中的第K个最大元素
class Solution {
    // 思路：回溯
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1);
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    public void backtrack(int k, int n, int start) {

        if (track.size() == k && n == 0) {
            res.add(new LinkedList<>(track));
        }
        //base case
        if (track.size() == k || n <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            //做选择
            track.add(i);
            //isVisited.add(i);
            n -= i;
            //回溯
            backtrack(k, n, i + 1);
            //撤销选择
            track.remove(Integer.valueOf(i));
            n += i;
        }
    }

}


