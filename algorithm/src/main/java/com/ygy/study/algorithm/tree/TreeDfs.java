package com.ygy.study.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树深度遍历
 */
public class TreeDfs {

    /**
     * 递归方式实现深度优先遍历
     * @param dfsList
     * @param treeNode
     */
    public static void recursionDfs(List<TreeNode> dfsList, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        dfsList.add(treeNode);

        if (null != treeNode.getLeft()) {
            recursionDfs(dfsList, treeNode.getLeft());
        }

        if (null != treeNode.getRight()) {
            recursionDfs(dfsList, treeNode.getRight());
        }

    }

    /**
     * 用栈数据结构，for循环方式深度优先遍历
     * @param treeNode
     * @return
     */
    public static List<TreeNode> foreachDfs(TreeNode treeNode) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (treeNode == null) {
            return treeNodes;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(treeNode);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            treeNodes.add(node);
            if (null!=node.getRight()) {
                stack.push(node.getRight());
            }
            if (null!=node.getLeft()) {
                stack.push(node.getLeft());
            }
        }
        return treeNodes;
    }


}
