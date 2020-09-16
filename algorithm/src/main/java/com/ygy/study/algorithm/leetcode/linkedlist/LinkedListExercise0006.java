package com.ygy.study.algorithm.leetcode.linkedlist;

import com.ygy.study.algorithm.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 单链表环路入口检测 难度中等
 *
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListExercise0006 {

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
        node16.next = node13;// 有环

        ListNode node = detectCycle(node11);
        System.out.println(node!=null?node.val:null);

        ListNode node2 = detectCycle2(node11);
        System.out.println(node2!=null?node2.val:null);
    }

    /**
     * 通过hashMap存储，查找，找到说明有环
     * 时间复杂度O（N）,空间复杂度O（N）
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node = head;
        while (null != node) {
            Integer value = map.get(node);
            if (null != value) {
                return node;
            }
            map.put(node, 1);
            node = node.next;
        }
        return null;
    }

    /**
     * 快慢指针
     *      步骤1：p1步长为1走，p2步长为2走，找到第一次相遇点（必然相遇）
     *      步骤2：p1从相遇点继续走，p3从开头步长为1开始走，p1、p2相遇则为环入口
     *      数学证明，网上自己找
     *      时间复杂度O（N）
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pSlow != null && pFast.next != null) {
            // pSlow走一步、pFast走两步
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            // 相遇必然有环
            if (pSlow == pFast) {
                ListNode pTemp = head;
                while (pTemp != pSlow) {
                    pTemp = pTemp.next;
                    pSlow = pSlow.next;
                }
                return pTemp;
            }
        }
        return null;
    }

}
