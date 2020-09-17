package com.ygy.study.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后续遍历
 */
public class TreePostOrder {

    /**
     * 递归后序遍历，左->右->根
     * @param root
     * @param treeNodes
     */
    public static void postOrderRecursion(TreeNode root, List<TreeNode> treeNodes) {
        if (null == root) {
            return;
        }
        postOrderRecursion(root.left, treeNodes);
        postOrderRecursion(root.right, treeNodes);
        treeNodes.add(root);
    }

    /**
     * for循环后序遍历
     *      左->右->根 转换成 根->右->左
     * @param root
     * @return
     */
    public static List<TreeNode> postOrderForeach(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (null == root) {
            return treeNodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            treeNodes.addFirst(treeNode);
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
        }
        return treeNodes;
    }

    /**
     * for循环后序遍历，左->右->根，常规
     * @param root
     * @return
     */
    public static List<TreeNode> postOrderForeach2(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (null == root) {
            return treeNodes;
        }
        // TODO
        return treeNodes;
    }

}
