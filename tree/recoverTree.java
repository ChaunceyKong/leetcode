import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


//99. 恢复二叉搜索树

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();



    }
}

class Solution {
    //思路：二叉搜索树中序遍历有序！
    public void recoverTree(TreeNode root) {
        inOrder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        // 中序遍历
        if (root.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;

        inOrder(root.right);
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


