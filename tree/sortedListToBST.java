import java.util.*;


//109. 有序链表转换二叉搜索树

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();



    }
}

class Solution {
    //思路：树总是用递归来实现
    // 关键点高度平衡，将链表左右对等分，分别构建左右子树
    // 明确递归函数返回的是什么
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        //存储有序链表的值
        LinkedList<Integer> list = new LinkedList<>();
        ListNode node =head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int left = 0, right = list.size() - 1;

        TreeNode root = buildSortTree(list,left,right);

        return root;
    }

    // 明确递归函数返回的是什么：返回平衡二叉树的根结点
    public TreeNode buildSortTree(LinkedList<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode();

        int mid = (left + right) / 2;

        root.val = list.get(mid);
        root.left = buildSortTree(list,left,mid-1);
        root.right = buildSortTree(list, mid+1, right);

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
