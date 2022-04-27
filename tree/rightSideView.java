import java.util.*;


//199. 二叉树的右视图

public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    // 思路：bfs层级遍历，记录最后一个结点，或者先遍历右子树，记录第一个结点；

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>(); // 结果集
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }

                if (i == sz -1) { // 到达该层的最后一个结点
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // 思路2：dfs
    // 先递归遍历右子树，记录层数，将该层最右边的结点加入结果集
    public List<Integer> rightSideView2(TreeNode root) {
        traverse(root);
        return ans;
    }

    List<Integer> ans = new LinkedList<>(); // 记录结果集
    int level = 0; //记录层级
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        level++;
        if (ans.size() < level) {
            ans.add(root.val);
        }

        traverse(root.right); //先遍历右子树
        traverse(root.left);

        level--;
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
