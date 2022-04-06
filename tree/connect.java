

//116. 填充每个节点的下一个右侧节点指针
public class Test {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n1.right = n3;
        n4.right = n5;

        Solution solution = new Solution();
        solution.connect(root);

    }
}

class Solution {
    //思路：树的解法一般需要 递归 实现
    //1.关注每一层
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connNode(root.left, root.right);
        return root;
    }

    public void connNode(Node node1, Node node2) {
        //base case
        if (node1 == null || node2 == null) {
            return;
        }


        node1.next = node2;

        connNode(node1.left, node1.right);
        connNode(node2.left, node2.right);
        connNode(node1.right, node2.left);

    }



}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
