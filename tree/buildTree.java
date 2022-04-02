import java.util.HashMap;

//105. 从前序与中序遍历序列构造二叉树
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路：递归
    //1.前序遍历都是 根结点-左子树-右子树
    //2.中序遍历都是 左子树-根结点-右子树
    //3.在前序遍历表中找到根结点，对应到中序遍历表中，确定左子树 和 右子树

    HashMap<Integer,Integer> valToIdx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIdx.put(inorder[i],i);
        }

        TreeNode root = build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);

        return root;
    }

    /**
     * 递归构建结点左右子树
     * @param preorder 前序遍历表
     * @param preStart 构建该树所需的前序遍历表的起点，对应了当前树的第一个结点，即根结点
     * @param preEnd 构建该树所需的前序遍历表的终点
     * @param inorder 中序遍历表
     * @param inStart 构建该树所需的中序遍历表的起点，
     * @param inEnd 构建该树所需的中序遍历表的终点
     * @return
     */
    public TreeNode build (int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd) {


        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIdx.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
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
