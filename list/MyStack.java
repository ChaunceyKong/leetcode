import java.util.LinkedList;
import java.util.Queue;

//225. 用队列实现栈
public class Test {
    public static void main(String[] args) {

    }
}

class MyStack {

    Queue<Integer> stack;
    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offer(x);
    }

    public int pop() {
        for (int i = 0; i < stack.size() - 1; i++) {
            stack.offer(stack.poll());
        }

        return stack.poll();
    }

    public int top() {
        int peek = 0;
        for (int i = 0; i < stack.size(); i++) {
            if (i == stack.size()-1) {
                peek = stack.peek();
            }
            stack.offer(stack.poll());
        }
        return peek;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}



