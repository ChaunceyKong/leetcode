import java.util.*;

// 141. 环形链表
public class Test {

    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};

        Solution solution = new Solution();


    }
}

class Solution {

    // 思路：
    // 1.使用List存储链表的每一个结点
    // 2.每一次判断node.next是否包含，若包含则true，否则加入HashMap，直到next==null，return false
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new LinkedList<>();
        ListNode node = head;

        while (node.next != null) {
            if (list.contains(node)) {
                return true;
            }

            list.add(node);
            node = node.next;
        }

        return false;
    }

    //思路2：快慢指针
    //1.慢指针每次移动一步，快指针每次移动两步
    //2.如果链表存在环，则快指针会追上慢指针
    //3.否则，当快指针==null，return false
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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
