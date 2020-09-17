package com.ygy.study.algorithm.leetcode.linkedlist;

import com.ygy.study.algorithm.linkedlist.LinkedListUtil;
import com.ygy.study.algorithm.linkedlist.ListNode;

/**
 * 合并K个升序链表
 *      给你一个链表数组，每个链表都已经按升序排列。
 *      请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *      示例 1：
 *      输入：lists = [[1,4,5],[1,3,4],[2,6]]
 *      输出：[1,1,2,3,4,4,5,6]
 *      解释：链表数组如下：
 *      [
 *        1->4->5,
 *        1->3->4,
 *        2->6
 *      ]
 *      将它们合并到一个有序链表中得到。
 *      1->1->2->3->4->4->5->6
 *
 *      示例 2：
 *      输入：lists = []
 *      输出：[]
 *
 *      示例 3：
 *      输入：lists = [[]]
 *      输出：[]
 *
 *      提示：
 *      k == lists.length
 *      0 <= k <= 10^4
 *      0 <= lists[i].length <= 500
 *      -10^4 <= lists[i][j] <= 10^4
 *      lists[i] 按 升序 排列
 *      lists[i].length 的总和不超过 10^4
 */
public class LinkedListExercise0007 {

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
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;

        ListNode node31 = new ListNode(3);
        ListNode node32 = new ListNode(7);
        ListNode node33 = new ListNode(9);
        ListNode node34 = new ListNode(12);
        ListNode node35 = new ListNode(13);
        node31.next = node32;
        node32.next = node33;
        node33.next = node34;
        node34.next = node35;

        ListNode[] lists = new ListNode[]{node11, node21, node31};
        ListNode node = mergeKLists(lists);
        LinkedListUtil.print(node);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (null==lists || lists.length<1) {
            return null;
        }
        int len = lists.length;
        while (len > 1) {
            // 两个两个合并
            int i = 0;
            int j = 0;
            for ( ; i < len - 1; i = i + 2) {
                ListNode node = LinkedListExercise0002.mergeTwoLists(lists[i], lists[i + 1]);
                lists[j++] = node;
            }
            // 奇数个
            if (len%2==1) {
                lists[j] = lists[i];
                len = j + 1;
            } else {
                len = j;
            }
        }
        return lists[0];
    }

}
