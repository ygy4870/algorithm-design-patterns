package com.ygy.study.algorithm.leetcode;

import com.ygy.study.algorithm.linkedlist.LinkedListUtil;
import com.ygy.study.algorithm.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 *  示例 1:
 *  输入: 1->1->2
 *  输出: 1->2
 *
 *  示例 2:
 *  输入: 1->1->2->3->3
 *  输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exercise0008 {

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

        ListNode listNode = deleteDuplicates(node11);
        LinkedListUtil.print(listNode);

        ListNode listNode2 = deleteDuplicates2(node11);
        LinkedListUtil.print(listNode2);
    }

    /**
     * 用Map记录已存在节点
     * 需要而外空间O(N)
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            ListNode listNode = map.get(temp.val);
            if (null == listNode) {
                map.put(temp.val, temp);
            } else {
                // 链表有序，所以查到的已存在的值肯定是相邻的
                listNode.next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * 暂存一个前置指针pre
     * 时间复杂度O(N)，空间复杂度O(1)
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next;
        ListNode pre = head;
        while (temp != null) {
            if (temp.val==pre.val) {
                pre.next = temp.next;
            } else {
                pre = temp;
            }
            temp = temp.next;
        }

        return head;
    }

}
