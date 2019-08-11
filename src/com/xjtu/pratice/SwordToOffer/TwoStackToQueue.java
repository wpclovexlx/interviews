package com.xjtu.pratice.SwordToOffer;

import java.util.Stack;

/*
 *
 * 用两个栈实现队列
 *
 * */
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() != 0 && !stack2.isEmpty()) {
            return stack2.pop();
        } else {
            int stack1Len = stack1.size();
            for (int i = 0; i < stack1Len; i++) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }
}
