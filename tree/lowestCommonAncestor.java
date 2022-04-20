import java.util.LinkedList;


//236. 二叉树的最近公共祖先

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    // 思路：回溯，遇到p或q就返回，最近公共祖先满足
    // 1.p，q分布在root异侧
    // 2.p=root，且q在root的左或右子树中
    // 3.q=root，且p在root的左或右子树中
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null) { //p,q分布在root两侧，即root就是最近公共祖先
            return root;
        }

        if (left == null && right == null) { //root左右子树都不含p，q，直接返回null
            return null;
        }
        return left == null?right:left;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


