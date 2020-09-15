package com.ygy.study.algorithm.leetcode.linkedlist;

import com.ygy.study.algorithm.linkedlist.LinkedListUtil;
import com.ygy.study.algorithm.linkedlist.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 *
 *      定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *      示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 *
 *      限制：
 *      0 <= 节点个数 <= 5000
 */
public class LinkedListExercise0001 {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(2);
        ListNode node14 = new ListNode(3);
        ListNode node15 = new ListNode(4);
        ListNode node16 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;

        ListNode listNode = reverseList(node11);
        LinkedListUtil.print(listNode);
    }

    /**
     * 单链反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode temp = head;
        ListNode temp1 = head.next;
        ListNode temp2 = null;
        while (null != temp1) {
            temp2 = temp1.next;
            temp1.next = temp;

            temp = temp1;
            temp1 = temp2;
        }
        head.next = null;

        return temp;
    }

}
