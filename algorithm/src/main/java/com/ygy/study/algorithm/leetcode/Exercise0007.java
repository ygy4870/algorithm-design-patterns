package com.ygy.study.algorithm.leetcode;

import com.ygy.study.algorithm.linkedlist.ListNode;

/**
 * 合并两个有序链表
 *      将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *      示例：
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 */
public class Exercise0007 {

    public static void main(String[] args) {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(8);
        ListNode node15 = new ListNode(10);
        ListNode node16 = new ListNode(13);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;


        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(12);
        ListNode node25 = new ListNode(15);
        ListNode node26 = new ListNode(16);
        ListNode node27 = new ListNode(17);
        ListNode node28 = new ListNode(18);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node27;
        node27.next = node28;

        ListNode listNode = mergeTwoLists(node11, node21);

        ListNode temp = listNode;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        ListNode root = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode current = null;
        while (null != temp1 && null != temp2) {

            ListNode temp = null;
            if (temp1.val < temp2.val) {
                temp = temp1;
                temp1 = temp1.next;
            } else {
                temp = temp2;
                temp2 = temp2.next;
            }

            if (null == root) {
                current = temp;
                root = temp;
            } else {
                current.next = temp;
                current = temp;
            }
        }
        if (null != temp1) {
            current.next = temp1;
        }
        if (null != temp2) {
            current.next = temp2;
        }
        return root;
    }

}
