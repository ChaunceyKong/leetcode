import java.util.*;


//117. 填充每个节点的下一个右侧节点指针 II

public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();


    }
}

class Solution {
    //思路：bfs，将同一层的左边结点next指向后一个
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            //遍历一层
            for (int i = 0; i < sz; i++) {
                Node node = q.poll();
                if (i == sz - 1) { //此时，表示到达该层的最后一个结点，其next直接赋值null
                    node.next = null;
                } else { //否则next赋值为q队列对头元素
                    node.next = q.peek();
                }

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }

    //思路2：改进bfs，因为bfs需要结点不停的出队入队，效率不高，可以只是用一个链表
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root;

        while (cur != null) { //退出循环时，表示这棵树遍历完成
            Node dummyHead = new Node();
            Node pre = dummyHead; //pre用于链接cur下一层的结点

            while (cur != null) { //退出循环时，表示本层遍历完
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }

                cur = cur.next;
            }
            cur = dummyHead.next; //将cur更新为下一层的第一个节点
        }

        return root;
    }

}

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

