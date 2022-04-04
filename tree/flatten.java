import java.util.LinkedList;
import java.util.List;

//114. 二叉树展开为链表
public class Test {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n1.right = n3;
        n4.right = n5;

        Solution solution = new Solution();
        solution.flatten(root);

        solution.preOrder(root);
        System.out.println(solution.res);


    }
}

class Solution {
    //思路：树的解法一般需要 递归 实现
    //1.把左子树和右子树分别拉平
    //2.把右子树接到左子树末尾，左子树变成根结点的右子树

    public void flatten(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        //********** 后序遍历 ************
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;
        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }


    List<Integer> res = new LinkedList<>();
    public void preOrder(TreeNode root) {

        if (root == null) {
            res.add(0);
            return;
        }

        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
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
