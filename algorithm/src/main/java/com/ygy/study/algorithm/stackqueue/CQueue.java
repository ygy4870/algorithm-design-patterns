package com.ygy.study.algorithm.stackqueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {

    }

    public int deleteHead() {
        return 0;
    }

}
