import java.util.*;


//103. 二叉树的锯齿形层序遍历

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();



    }
}

class Solution {
    //思路：bfs
    // 相比 102. 二叉树的层序遍历 ，flag控制list add的方向就行
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false; //标志：false表示从左往右，true表示从右往左
        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if (flag) { //从右往左，即addFirst
                    level.addFirst(node.val);
                }
                else { //从左往右，即addLast
                    level.addLast(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            flag = !flag; //切换方向
            res.add(level);
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


