
//215. 数组中的第K个最大元素
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Solution {
    // 思路：前序遍历，计算个数
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        preOrder(root);
        return count;
    }

    int count;
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        count++;
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



