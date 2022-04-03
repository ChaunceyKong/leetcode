
//98. 验证二叉搜索树
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路1：树的解法一般需要 递归 实现
    //只关注一层树结构，根结点如何处理
    //注意：二叉搜索树要求，左子树所有结点都小于根结点，右子树所有结点都大于根结点
    //因此不能独立比较当前层左右结点大小
    //递归函数需要包含min max 参数记录并传递各层
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    //递归函数
    public boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        //base case
        if (root == null) {
            return true;
        }
        //根结点比最小值小，直接返回false
        if (min != null && root.val <= min.val) {
            return false;
        }
        //根结点比最大值大，直接返回false
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isBST(root.left, min, root) && isBST(root.right, root, max);

    }

    //思路2：二叉搜索树性质：中序遍历为从小到大的有序数组
    //因此，对二叉搜索树进行中序遍历，若前一个结点数值大于当前结点数值，则false，否则true
    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        //判断左子树
        if (!isValidBST2(root.left)) {
            return false;
        }
        //*******中序遍历********
        if (root.val < pre) {
            return false;
        }
        pre = root.val;
        //**********************
        //判断右子树
        if (!isValidBST2(root.right)) {
            return false;
        }
        return true;
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
