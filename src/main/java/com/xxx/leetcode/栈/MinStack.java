package com.xxx.leetcode.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 最小栈
 * @author: liujiabing
 * @create: 2023-04-07 03:32
 **/

public class MinStack {
    private final Deque<Integer> xStack = new LinkedList<>();
    private final Deque<Integer> mStack = new LinkedList<>();

    public MinStack() {
        mStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        mStack.push(Math.min(val, mStack.peek()));
    }

    public void pop() {
        xStack.pop();
        mStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }

}