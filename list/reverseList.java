

// 206. 反转链表
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
    }
}

class Solution {
    // 思路1：头插法，天然的倒序
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        ListNode cur = head;

        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = tempNode;
        }

        return dummyHead.next;
    }

    // 思路2：递归
    // 假设nk结点之后已经反转，即 n0->...->nk->nk+1<-...
    // 若要反转nk，需要nk+1->nk，则有 nk.next.next = nk
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList2(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}