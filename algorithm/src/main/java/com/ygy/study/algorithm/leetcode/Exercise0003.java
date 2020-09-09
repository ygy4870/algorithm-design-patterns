package com.ygy.study.algorithm.leetcode;

import com.ygy.study.algorithm.linkedlist.ListNode;

/**
 *      两数相加
 *      给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 *      如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *      示例：
 *
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 465 = 807
 *
 *      来源：力扣（LeetCode）
 *      链接：https://leetcode-cn.com/problems/add-two-numbers
 *      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exercise0003 {

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        ListNode listNode = addTwoNumbers(listNode11, listNode21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        if (null == listNode1) {
            return listNode2;
        }
        if (null == listNode2) {
            return listNode1;
        }

        ListNode node1 = listNode1;
        int weight1 = 1;
        int number1 = 0;
        while (null != node1) {
            number1 += node1.val * weight1;
            weight1 *= 10;
            node1 = node1.next;
        }

        ListNode node2 = listNode2;
        int weight2 = 1;
        int number2 = 0;
        while (null != node2) {
            number2 += node2.val * weight2;
            weight2 *= 10;
            node2 = node2.next;
        }

        ListNode listNode = null;
        ListNode currentNode = null;
        int number3 = number1 + number2;
        while (number3 != 0) {
            int remainder = number3 % 10;
            number3 = number3 / 10;

            ListNode tempNode = new ListNode(remainder);
            if (null == currentNode) {
                listNode = tempNode;
                currentNode = tempNode;
            } else {
                currentNode.next = tempNode;
                currentNode = tempNode;
            }
        }

        return listNode;
    }

}
