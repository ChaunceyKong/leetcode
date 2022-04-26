import java.util.*;


//124. 二叉树中的最大路径和

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}

class Solution {
    //思路：最大路径和--->动态规划,无法设置dp大小
    //用递归，明确递归函数返回值：当前root结点树的最大路径和！
    //当前root树的最大路径和=Math.max{left,right},  min{left,right}+root<0
    //                   =Math.max{left,right},  min{left,right}+root<0
    //以上思路错误，因为求得的子树最大和路径可能无法连接在一起！
    //-------------------------------------------------------------------
    //以上思路并非完全错误
    //最大路径有3种情况：左-跟-右、左-根-父、右-根-父
    //对于第一种情况：无法递归，只能全局搜索最大
    //对于2、3种情况：递归搜索最大路径

    int max = Integer.MIN_VALUE; //全局最大值
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //单枝情况下，即left-root 或者 right-root 递归寻找最大路径和
        //若左边或者右边为负数，舍弃
        int leftMaxSum = Math.max(0,dfs(root.left));
        int rightMaxSum = Math.max(0,dfs(root.right));
        //双支情况下，即left-root-right，更新全局最大值
        max = Math.max(max, leftMaxSum + root.val + rightMaxSum);

        return Math.max(leftMaxSum,rightMaxSum)+ root.val; //返回单枝情况，向上回溯

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
