package com.ygy.study.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 */
public class TreePreOrder {

    /**
     * 递归前序遍历，根->左->右
     * @param root
     * @param treeNodes
     */
    public static void preOrderRecursion(TreeNode root, List<TreeNode> treeNodes) {
        if (null == root) {
            return;
        }
        treeNodes.add(root);
        preOrderRecursion(root.left, treeNodes);
        preOrderRecursion(root.right, treeNodes);
    }

    /**
     * 用栈方式遍历，根->左->右
     * @param root
     * @return
     */
    public static List<TreeNode> preOrderForeach(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (null == root) {
            return treeNodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            treeNodes.add(node);
            if (null != node.getRight()) {
                stack.push(node.getRight());
            }
            if (null != node.getLeft()) {
                stack.push(node.getLeft());
            }
        }
        return treeNodes;
    }

}
