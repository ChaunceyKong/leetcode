import java.util.*;


//404. 左叶子之和

public class Test {
    // 思路1：遍历 or 分解问题
    // 遍历：维护一个全局结果变量
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return res;
    }

    int res = 0;
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) { //root.left 是左叶子结点
            res += root.left.val;
        }

        traverse(root.left);
        traverse(root.right);
    }

    //思路2：层序遍历
    // 如果 node.left.left == null && node.left.right == null 是左叶子结点
    public int sumOfLeftLeaves2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0; //结果集
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
            if (node.left != null && node.left.left == null && node.left.right == null) { //node.left 是左叶子结点
                ans += node.left.val;
            }
        }
        return ans;
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
