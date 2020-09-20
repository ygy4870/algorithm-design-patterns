package com.ygy.study.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class TreeInOrder {

    /**
     * 递归中序遍历，左->根->右
     * @param root
     * @param treeNodes
     */
    public static void inOrderRecursion(TreeNode root, List<TreeNode> treeNodes) {
        if (null == root) {
            return;
        }
        inOrderRecursion(root.left, treeNodes);
        treeNodes.add(root);
        inOrderRecursion(root.right, treeNodes);
    }

    /**
     * for循环中序遍历，左->根->右
     * @param root
     * @return
     */
    public static List<TreeNode> inOrderForeach(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (null == root) {
            return treeNodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode current;
        while (!stack.isEmpty()) {
            current = stack.peek();
            while (null!=current.left) {
                stack.push(current.left);
                current = current.left;
            }

            current = stack.pop();

            while (current!=null) {
                treeNodes.add(current);
                if (current.right==null) {
                    current = stack.isEmpty()?null:stack.pop();
                } else {
                    stack.push(current.right);
                    break;
                }
            }
        }
        return treeNodes;
    }

}
