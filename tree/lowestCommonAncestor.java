import java.util.LinkedList;


//235. 二叉搜索树的最近公共祖先

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    // 思路：递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val > q.val) {
            return lowestCommonAncestor(root,q,p);
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


