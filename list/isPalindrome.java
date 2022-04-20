import java.util.LinkedList;


//234. 回文链表

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }
}

class Solution {
    // 思路1：使用栈
    // 1.偶数个结点：当前链表元素值与栈顶元素不相同，入栈，否则出栈
    // 2.奇数个结点：跳过中间一个结点
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        node = head;
        LinkedList<Integer> stack = new LinkedList<>();
        if (len % 2 == 0) { // 偶数
            while (node != null) {
                if (stack.peek() == null || stack.peek() != node.val) { //如果栈顶元素与当前结点值不相同，入栈
                    stack.push(node.val);
                }
                else {
                    stack.pop();
                }
                node = node.next;
            }
            return stack.isEmpty();
        }
        else {
            int idx = 0;
            while (node != null) {
                if (idx == len / 2) {
                    node = node.next;
                    idx++;
                    continue;
                }

                if (stack.peek() == null || stack.peek() != node.val) { //如果栈顶元素与当前结点值不相同，入栈
                    stack.push(node.val);
                }
                else {
                    stack.pop();
                }
                node = node.next;
                idx++;
            }
            return stack.isEmpty();
        }
    }

    // 思路2：双指针+反转后面链表
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode right = resverse(slow);
        ListNode left = head;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode resverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            // pre cur 向后移一个
            pre = cur;
            cur = next;
        }
        return pre;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


