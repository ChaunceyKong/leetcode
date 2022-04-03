import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//95. 不同的二叉搜索树 II
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路：树的解法一般需要 递归 实现
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    public List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }

        //1.穷举root的所有可能结果
        for (int i = lo; i <= hi; i++) {
            //2.递归构造所有合法左右子树BST
            //左子树
            List<TreeNode> leftTree = build(lo, i-1);
            //右子树
            List<TreeNode> rightTree = build(i+1,hi);
            //3.root结点穷举所有左右子树组合
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
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
