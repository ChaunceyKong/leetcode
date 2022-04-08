import java.util.*;

// 146. LRU 缓存
public class Test {

    public static void main(String[] args) {


    }
}

class Solution {
    // 思路1：两个列表分别存储这两个链表
    // 依次比较是否包含
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> listA = new LinkedList<>();
        List<ListNode> listB = new LinkedList<>();
        ListNode node = headA;

        while (node != null) { //将链表A各结点存进listA
            listA.add(node);
            node = node.next;
        }

        node = headB;
        while (node != null) { //将链表B各结点存进listB
            listB.add(node);
            node = node.next;
        }

        //判断listA中各结点是否包含在listB中，若是返回，否则返回null
        for (int i = 0; i < listA.size(); i++) {
            if (listB.contains(listA.get(i))) {
                return listA.get(i);
            }
        }

        return null;
    }

    // 思路2：若有公共部分，则 a+c   b+c
    // 将两条链表连接  a+c+b+c  b+c+a+c ，因此走过相同长度a+c+b（b+c+a）后，相遇点c就是公共部分
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            }
            else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            }
            else {
                nodeB = nodeB.next;
            }
        }

        return nodeA;
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