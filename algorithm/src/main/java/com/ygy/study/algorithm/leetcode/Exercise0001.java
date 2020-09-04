package com.ygy.study.algorithm.leetcode;

import com.ygy.study.algorithm.common.TreeNode;
import com.ygy.study.algorithm.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

/**
 *    给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 *    说明: 叶子节点是指没有子节点的节点。
 *
 *    示例:
 *
 *    输入:
 *
 *       1
 *     /   \
 *    2     3
 *     \
 *      5
 *
 *    输出: ["1->2->5", "1->3"]
 *    解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class Exercise0001 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildRandomTree(5, 100);
        List<String> paths = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();

        findTreePaths(paths, treeNodes, treeNode);
    }

    private static void findTreePaths(List<String> paths, List<TreeNode> treeNodes, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            treeNodes.add(node);

            // 处理叶子节点
            if (null == node.getLeft() && null == node.getRight()) {
                StringJoiner sj = new StringJoiner("->", "[" ,"]");
                for (TreeNode tmp : treeNodes) {
                    sj.add(""+tmp.getVal());
                }
                paths.add(sj.toString());

                while (!treeNodes.isEmpty()) {
                    treeNodes.remove(treeNodes.size()-1);
                }

            }

            if (node.getRight() == null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() == null) {
                stack.push(node.getLeft());
            }

        }
    }

}
