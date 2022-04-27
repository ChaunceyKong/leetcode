import java.util.*;


//297. 二叉树的序列化与反序列化

public class Codec {

    // Encodes a tree to a single string.
    // 思路：对树进行前序遍历，遍历时将结点值变成字符串
    String NULL = "#";
    String gap = ",";
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();

        preOrderSerialize(root, str);
        return str.toString();
    }

    // 前序遍历 序列化
    public void preOrderSerialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append(NULL).append(gap);
            return;
        }

        str.append(root.val).append(gap);

        preOrderSerialize(root.left, str);
        preOrderSerialize(root.right, str);

    }

    // Decodes your encoded data to tree.
    // 根据前序遍历结果，恢复二叉树
    public TreeNode deserialize(String data) {

        String[] strs = data.split(",");
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(strs));

        return preOrderDeserialize(nodes);

    }

    //前序遍历 反序列化
    public TreeNode preOrderDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String str = nodes.removeFirst();
        if (str.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));

        root.left = preOrderDeserialize(nodes);
        root.right = preOrderDeserialize(nodes);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
