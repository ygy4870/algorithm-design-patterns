package com.ygy.study.algorithm.leetcode.linkedlist;

import com.ygy.study.algorithm.linkedlist.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 *  如果两个链表没有交点，返回 null.
 * 	在返回结果后，两个链表仍须保持原有的结构。
 * 	可假定整个链表结构中没有循环。
 * 	程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListExercise0005 {

    public static void main(String[] args) {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(2);
        ListNode node14 = new ListNode(3);
        ListNode node15 = new ListNode(40);
        ListNode node16 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(10);
        ListNode node23 = node15;
        ListNode node24 = node16;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        ListNode node = getIntersectionNode(node11, node11);
        ListNode nodeNew = getIntersectionNode2(node11, node11);
        System.out.println(null != node ? node.val : "");
        System.out.println(null != nodeNew ? nodeNew.val : "");

        ListNode node2 = getIntersectionNode(node11, node21);
        ListNode node2New = getIntersectionNode2(node11, node21);
        System.out.println(null != node2 ? node2.val : "");
        System.out.println(null != node2New ? node2New.val : "");

    }

    /**
     * 通过长度差，找交点
     * 时间复杂度
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }

        // 计算长度
        int lenA = 0;
        ListNode temp = headA;
        while (null != temp) {
            lenA++;
            temp = temp.next;
        }
        int lenB = 0;
        temp = headB;
        while (null != temp) {
            lenB++;
            temp = temp.next;
        }

        // 长度差
        int lenDiff = 0;
        ListNode shortListNode;
        ListNode longListNode;
        if (lenA < lenB) {
            lenDiff = lenB - lenA;
            shortListNode = headA;
            longListNode = headB;
        } else {
            lenDiff = lenA - lenB;
            shortListNode = headB;
            longListNode = headA;
        }

        // 长的链表先走到超长的位置
        for (int i = 0; i < lenDiff; i++) {
            longListNode = longListNode.next;
        }

        while (null != longListNode && null != shortListNode) {
            if (longListNode == shortListNode) {
                return shortListNode;
            }
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        return null;
    }

    /**
     * 双指针法
     *      只要有交点，同样的速度，一直走必然走到同样路程的交点处
     *      A链到交点的长度 + 交点后的长度 + B链到交点的长度 = B链到交点的长度 + 交点后的长度 + A链到交点的长度
     *      注意：
     *          如果不相交，（A链到交点的长度 + 交点后的长度 + B链到交点的长度） < (A链长度 + B链长度)，以此做遍历界限即可
     *  话外：
     *      错的人迟早会走散，而对的人迟早会相逢！
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        int lenA = 0;
        int lenB = 0;
        int i = 0;
        while (null != pA && null != pB) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;

            // A链遍历完走B链
            if (null == pA) {
                pA = headB;
                lenA = i;
            }

            // B链遍历完走A链
            if (null == pB) {
                pB = headA;
                lenB = i;
            }

            // 走（lenA+lenB）步，依然没有相遇，那就是错的人了
            if (lenA != 0 && lenB != 0 && i > (lenA + lenB)) {
                break;
            }

            i++;
        }
        return null;
    }


}
