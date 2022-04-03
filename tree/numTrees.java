import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//96. 不同的二叉搜索树
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路：树的解法一般需要 递归 实现
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        // 备忘录的值初始化为 -1
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return treeNum(1, n);
    }

    public int treeNum(int lo, int hi) {

        if (lo > hi) {
            return 1;
        }
        // 查备忘录
        if (memo[lo][hi] != -1) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int leftTreeNum = treeNum(lo, i - 1);
            int rightTreeNum = treeNum(i + 1, hi);

            // 左右子树的组合数乘积是 BST 的总数
            res += leftTreeNum * rightTreeNum;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
