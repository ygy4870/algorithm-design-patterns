package com.ygy.study.algorithm.tree;

import java.util.*;

/**
 * 二叉树层次遍历
 */
public class TreeBfs {

    /**
     * 层次遍历的重点是使用队列
     * @param root
     * @return
     */
    public static List<TreeNode> bfsTraversal(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (null == root) {
            return treeNodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            treeNodes.add(node);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        return treeNodes;
    }

}
