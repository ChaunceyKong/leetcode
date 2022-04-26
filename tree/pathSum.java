import java.util.*;


//113. 路径总和 II

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.left = n9;
        n6.right = n10;

        System.out.println(solution.pathSum2(n1,22));


    }
}

class Solution {
    //思路1：DFS 回溯
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum);
        return res;
    }

    List<List<Integer>> res = new LinkedList<>(); // 结果集
    LinkedList<Integer> trace = new LinkedList<>();

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        trace.addLast(root.val);

        if (root.left == null && root.right == null && targetSum == 0) { //叶子结点
            res.add(new LinkedList<>(trace));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        //撤销选择
        //遍历完当前结点的左右子结点后，再弹出root，否则遍历右子树的时候就没有root结点了
        trace.removeLast();
    }

    //思路2：BFS
    Map<TreeNode,TreeNode> map = new HashMap<>(); // 存储结点的父结点，用于恢复路径
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qSum = new LinkedList<>();

        q.offer(root);
        qSum.offer(0);
        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                int sum = qSum.poll() + node.val;

                if (node.left == null && node.right == null) { //达到叶子结点
                    if (sum == targetSum) {
                        getTrace(node);
                    }
                } else {
                    if (node.left != null) {
                        q.offer(node.left);
                        map.put(node.left, node);
                        qSum.offer(sum);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                        map.put(node.right, node);
                        qSum.offer(sum);
                    }
                }
            }
        }
        return res;
    }

    public void getTrace(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(list);
        res.add(new LinkedList<>(list));
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

