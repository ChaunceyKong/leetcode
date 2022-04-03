import java.util.HashMap;

//106. 从中序与后序遍历序列构造二叉树
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路：树的解法一般需要 递归 实现
    //树的递归，关键一层中 根结点 的处理
    //中序遍历：左-根-右
    //后序遍历：左-右-根
    HashMap<Integer,Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {


        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        //中序遍历中根结点的索引
        int index = valToIndex.get(postorder[postEnd]);
        //左子树结点个数
        int leftSize = index - inStart;
        
        root.left = build(inorder, inStart, valToIndex.get(root.val) - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, valToIndex.get(root.val) + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
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
