package com.ygy.study.algorithm.linkedlist;

import lombok.Data;

@Data
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
