import java.util.*;


//102. 二叉树的层序遍历

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();



    }
}

class Solution {
    //思路：bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 当树为空树时，直接返回空列表
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> list = new LinkedList<>(); //记录每层的结点值
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            res.add(list);
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


