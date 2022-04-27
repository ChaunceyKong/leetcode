import java.util.*;


//129. 求根节点到叶节点数字之和

public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    // 思路：dfs遍历每条路径，存储各条路径的结点值，再相加。
    // 问题：如何转换成数字相加？
    // 列表套栈，一个栈存储一个路径的各个权重，列表存储全部路径

    public int sumNumbers(TreeNode root) {
        dfs(root);
        int len = 0;
        for (Deque<Integer> nums : list) { // 求最长路径数字位数
            len = Math.max(len, nums.size());
        }
        int sum = 0; // 最终结果
        for (int i = 0, weight = 1; i < len; i++, weight *= 10) {
            int sumTemp = 0;
            for (Deque<Integer> nums : list) {
                if (nums.peek() != null) {
                    sumTemp += nums.pop();
                }
            }
            sum += sumTemp * weight;
        }
        return sum;
    }

    List<Deque<Integer>> list = new LinkedList<>();
    Deque<Integer> stack = new LinkedList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        stack.push(root.val);
        if (root.left == null && root.right == null) {
            list.add(new LinkedList<>(stack));
        }

        dfs(root.left);
        dfs(root.right);
        stack.pop();
    }

    //改进：StringBuffer str 存储路径权值，Integer.parseInt(str.toString()) 可以直接转化为整数
    StringBuffer str = new StringBuffer();
    int ans = 0; // 结果
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历，记录结点值
        str.append(root.val);
        if (root.left == null && root.right ==null) { //到达叶子结点，求路径和
            ans += Integer.parseInt(str.toString());
        }

        traverse(root.left);
        traverse(root.right);
        // 撤销选择
        str.deleteCharAt(str.length() - 1);
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
