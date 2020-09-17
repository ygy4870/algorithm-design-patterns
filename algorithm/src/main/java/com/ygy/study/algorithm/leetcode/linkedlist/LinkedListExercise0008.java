package com.ygy.study.algorithm.leetcode.linkedlist;

import com.ygy.study.algorithm.linkedlist.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 *      请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *      还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *      示例 1：
 *      输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *      输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *      示例 2：
 *      输入：head = [[1,1],[2,1]]
 *      输出：[[1,1],[2,1]]
 *
 *      示例 3：
 *      输入：head = [[3,null],[3,0],[3,null]]
 *      输出：[[3,null],[3,0],[3,null]]
 *
 *       示例 4：
 *      输入：head = []
 *      输出：[]
 *      解释：给定的链表为空（空指针），因此返回 null。
 *
 *      提示：
 *      -10000 <= Node.val <= 10000
 *      Node.random 为空（null）或指向链表中的节点。
 *      节点数目不超过 1000 。
 */
public class LinkedListExercise0008 {

    public static void main(String[] args) {

        Node node11 = new Node(1);
        Node node12 = new Node(3);
        Node node13 = new Node(4);
        Node node14 = new Node(8);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node11.random = null;
        node12.random = node14;
        node13.random = node11;
        node14.random = node11;

        Node node = copyRandomList(node11);
        System.out.println(node);

        Node node2 = copyRandomList2(node11);
        System.out.println(node2);

        Node node3 = copyRandomList3(node11);
        System.out.println(node3);
    }

    /**
     * 时间复杂度O（N）
     * 空间复杂度O（N）
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        // 第一次遍历，复制next指针，并记录新旧对应关系
        Node temp = head;
        Node headCopy = null;
        Node tempCopy = null;
        Map<Node, Node> map = new HashMap<>();
        while (null != temp) {
            Node node = new Node(temp.val);
            if (null == headCopy) {
                headCopy = node;
                tempCopy = node;
            } else {
                tempCopy.next = node;
                tempCopy = tempCopy.next;
            }
            // 记录新旧对应关系
            map.put(temp, tempCopy);

            temp = temp.next;
        }

        // 复制random指针
        temp = head;
        tempCopy = headCopy;
        while (null != temp) {
            Node node = map.get(temp.random);
            tempCopy.random = node;

            temp = temp.next;
            tempCopy = tempCopy.next;
        }

        return headCopy;
    }

    /**
     * 层次遍历复制--（层次/深度遍历是图遍历的概念，包含但不限于树、链表）
     * 时间复杂度O（N），空间复杂度O（N）
     * @param head
     * @return
     */
    public static Node copyRandomList2(Node head) {
        if (null == head) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node headCopy = new Node(head.val);
        map.put(head, headCopy);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node nodeCopy = map.get(node);

            Node nodeNextCopy = new Node(node.next.val);
            if (node.next != null && null == nodeNextCopy) {
                nodeNextCopy = new Node(node.next.val);
                map.put(node.next, nodeNextCopy);
                queue.offer(node.next);
            }
            nodeCopy.next = nodeNextCopy;

            Node nodeRandomCopy = map.get(node.random);
            if (node.random != null && null == nodeRandomCopy) {
                nodeRandomCopy = new Node(node.random.val);
                map.put(node.random, nodeRandomCopy);
            }
            nodeCopy.random = nodeRandomCopy;
        }
        return headCopy;
    }

    /**
     * 复制法，在下一个位置
     * @param head
     * @return
     */
    public static Node copyRandomList3(Node head) {
        if (null == head) {
            return null;
        }

        Node current = head;
        while (null != current) {
            // 复制节点
            Node nodeCopy = new Node(current.val);
            // 复制的节点插在后面
            Node temp = current.next;
            current.next = nodeCopy;
            nodeCopy.next = temp;

            current = temp;
        }

        current = head;
        while (null != current) {
            current.next.random = current.random;
            current = current.next.next;
        }

        Node head2 = head.next;
        current = head2;
        while (null != current) {
            if (null == current.next) {
                break;
            }
            Node temp = current.next.next;
            current.next = current.next.next;
            current = temp;
        }

        return head2;
    }

}
