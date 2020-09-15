package com.ygy.study.algorithm.linkedlist;

public class LinkedListUtil {

    public static void print(ListNode head) {
        if (null==head) {
            return;
        }
        ListNode temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
