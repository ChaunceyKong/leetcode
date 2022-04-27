import java.util.*;


//173. 二叉搜索树迭代器

public class Test {
    public static void main(String[] args) {

    }
}
// 思路1：将BST的中序遍历结果提前保存在一个列表中，然后依次取出队列头元素
class BSTIterator {

    int next;
    public BSTIterator(TreeNode root) {
        next= Integer.MIN_VALUE;
        inOrder(root);
    }

    public int next() {
        if (next == Integer.MIN_VALUE) {
            next = 0;
        } else {
            next++;
        }

        return list.get(next);
    }

    public boolean hasNext() {
        if ((next + 1) < list.size()) {
            return true;
        }
        return false;
    }

    // 中序遍历
    List<Integer> list = new LinkedList<>();
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

// 思路2：使用栈模拟递归
// 先将最左路径结点入栈，依次弹出，若该结点有左路径，入栈，弹出....
class BSTIterator2 {

    Stack<TreeNode> stack;
    public BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeftBranch(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //将左侧树枝入栈
    public void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
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
