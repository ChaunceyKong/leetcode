import java.util.*;

// 142. 环形链表 II
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();


    }
}

class Solution {
    // 思路1：链表存储
    // 依次遍历链表存储到LinkedList中，indexOf返回链表第一次出现元素位置
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new LinkedList<>();
        ListNode node = head;

        int index = -1;

        while (node != null) {
            if (!list.contains(node)) {
                list.add(node);
                node = node.next;
                continue;
            }

            index = list.indexOf(node);
            return list.get(index);
        }
        return null;
    }

}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
