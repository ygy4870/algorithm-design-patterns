package com.ygy.study.algorithm.linkedlist;

import java.util.StringJoiner;

public class LinkedListUtil {

    public static void print(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode temp = head;
        StringJoiner sj = new StringJoiner("->", "", "");
        while (temp != null) {
            sj.add("" + temp.val);
            temp = temp.next;
        }
        System.out.println(sj.toString());
    }

}
