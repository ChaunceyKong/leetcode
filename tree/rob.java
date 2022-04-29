import java.util.*;


//337. 打家劫舍 III

public class Test {

    // 思路：遍历 or 分解问题
    // ”最高金额“ ===> dp ===> 分解问题
    // 当前结点的最高金额=左右子树最高金额
    //                =左右子树的子树最高金额+root.val
    Map<TreeNode,Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        //抢root
        int do_it = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //不抢root
        int no_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it , no_do);
        memo.put(root,res);
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
