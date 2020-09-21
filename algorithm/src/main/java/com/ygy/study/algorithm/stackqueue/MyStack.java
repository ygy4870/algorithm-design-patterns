package com.ygy.study.algorithm.stackqueue;

import java.util.LinkedList;

/**
 * 使用队列实现栈的下列操作：
 *
 * 	push(x) -- 元素 x 入栈
 * 	pop() -- 移除栈顶元素
 * 	top() -- 获取栈顶元素
 * 	empty() -- 返回栈是否为空
 *
 * 注意:
 *
 * 	你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 	你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 	你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class MyStack {

    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return 0;
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                Integer poll = queue1.poll();
                queue2.offer(poll);
            }
            return queue1.poll();
        } else {
            while (queue2.size() > 1) {
                Integer poll = queue2.poll();
                queue1.offer(poll);
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return 0;
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                Integer poll = queue1.poll();
                queue2.offer(poll);
            }
            Integer poll = queue1.poll();
            queue2.offer(poll);
            return poll;
        } else {
            while (queue2.size() > 1) {
                Integer poll = queue2.poll();
                queue1.offer(poll);
            }
            Integer poll = queue2.poll();
            queue1.offer(poll);
            return poll;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
