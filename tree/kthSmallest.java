import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//230. 二叉搜索树中第K小的元素
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Solution {
    // 思路：二叉搜索树中序遍历就是升序，即返回中序遍历第k个结果
    public int kthSmallest(TreeNode root, int k) {
        infixOrder(root, k);
        return num;
    }

    // 中序遍历
    int num;
    int step;
    public void infixOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        infixOrder(root.left, k);
        step++;
        if (step == k) {
            num = root.val;
        }
        infixOrder(root.right, k);
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




