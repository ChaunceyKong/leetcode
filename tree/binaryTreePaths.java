import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


//257. 二叉树的所有路径

public class Test {
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(n1));

    }
}

class Solution {
    //思路：前序遍历
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        preOrder(root);
        return res;
    }

    //前序遍历
    LinkedList<String> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //如果是叶子结点
        if (root.left == null && root.right == null) {
            track.addLast(root.val+"");
            res.addLast(String.join("->",track));
            track.removeLast();
            return;
        }

        track.addLast(root.val+"");
        preOrder(root.left);
        preOrder(root.right);
        track.removeLast();
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


