import java.util.Stack;

//232. 用栈实现队列

public class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

class MyQueue {

    Stack<Integer> stack1;

    public MyQueue() {
        stack1 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int head = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return head;
    }

    public int peek() {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        int head = stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return head;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}



