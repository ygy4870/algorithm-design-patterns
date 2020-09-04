package com.ygy.study.algorithm.dfs;

import com.ygy.study.algorithm.common.TreeNode;
import com.ygy.study.algorithm.common.TreeUtil;

import java.util.*;

public class TreeDfs {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.buildRandomTree(5, 100);
        List<Integer> dfsList = new ArrayList<Integer>();
        recursionDfs(dfsList, root);
        System.out.println(dfsList);

        List<Integer> dfsList2 = new ArrayList<Integer>();
        foreachDfs(dfsList2, root);
        System.out.println(dfsList2);
    }

    /**
     * 递归方式实现深度优先遍历
     * @param dfsList
     * @param treeNode
     */
    public static void recursionDfs(List<Integer> dfsList, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        dfsList.add(treeNode.getVal());

        if (null != treeNode.getLeft()) {
            recursionDfs(dfsList, treeNode.getLeft());
        }

        if (null != treeNode.getRight()) {
            recursionDfs(dfsList, treeNode.getRight());
        }

    }

    /**
     * 用栈数据结构，for循环方式深度优先遍历
     * @param dfsList
     * @param treeNode
     */
    public static void foreachDfs(List<Integer> dfsList, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(treeNode);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            dfsList.add(node.getVal());

            if (null!=node.getRight()) {
                stack.push(node.getRight());
            }
            if (null!=node.getLeft()) {
                stack.push(node.getLeft());
            }

        }

    }


}
