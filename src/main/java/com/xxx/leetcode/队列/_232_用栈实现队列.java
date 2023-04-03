package 队列;

import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/10/21
 */
public class _232_用栈实现队列 {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        System.out.println(integers.pop());

    }
}

class MyQueue {
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    int front = 0;

    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

