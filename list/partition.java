import java.util.*;
//86. 分隔链表
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution solution = new Solution();
        ListNode headNew = solution.partition(head,3);

        for (ListNode node = headNew; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    //思路：
    //定义两个头结点，分别表示小于x的头结点 和 大于等于x的头结点
    //最后两个链表首尾相连即可
    public ListNode partition(ListNode head, int x) {
        ListNode dunmmyHead_min = new ListNode(); //小于x的链表头结点
        ListNode minNode = dunmmyHead_min; //小于x链表的索引
        ListNode dunmmyHead_max = new ListNode(); //大于等于x的链表头结点
        ListNode maxNode = dunmmyHead_max; //大于等于x链表的索引

        //如果链表为空或者只有一个结点，直接返回
        if (head.next == null || head == null) {
            return head;
        }

        //遍历链表每一个结点
        for (ListNode node = head; node != null; node = node.next) {
            if (node.val < x) { //小于x的结点加到min链表
                minNode.next = node;
                minNode = minNode.next;
            }
            else { //大于等于x的结点加到max链表
                maxNode.next = node;
                maxNode = maxNode.next;

            }
        }
        maxNode.next = null; //防止最后一个大于等于x的结点后面接有小于x的结点，而形成闭环
        minNode.next = dunmmyHead_max.next;

        return dunmmyHead_min.next;
    }
}