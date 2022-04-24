import java.util.*;


//107. 二叉树的层序遍历 II

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();



    }
}

class Solution {
    //思路：bfs
    // 相比 102. 二叉树的层序遍历 ，最后反转列表，或者每次添加到res的头部
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();

                level.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            //或者添加到res头部
            //res.addFirst(level);
            res.add(level);
        }
        Collections.reverse(res);

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


