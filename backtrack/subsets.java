import java.util.ArrayList;
import java.util.List;

//78. 子集
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

        List<List<Integer>> result = solution.subsets(new int[]{1,2,3});

        System.out.println(result);


    }
}

class Solution {
    //思路：回溯
    //画出回溯树，回溯树上每个结点都是子集，而非仅叶子结点

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(track);
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {

        //遍历 dfs
        for (int i = start; i <nums.length; i++ ) {
            //做选择
            track.add(nums[i]);
            result.add(new ArrayList<>(track));
            //回溯
            backtrack(nums, i + 1);
            //撤销选择
            track.remove(Integer.valueOf(nums[i]));
        }
    }
}