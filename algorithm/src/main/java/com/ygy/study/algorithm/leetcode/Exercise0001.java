package com.ygy.study.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
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
        List<String> paths = findTreePaths(treeNode);
        System.out.println(JSON.toJSON(paths));


//        TreeNode treeNode = buildTestTreeNode();
//        List<String> paths = findTreePaths(treeNode);
//        System.out.println(JSON.toJSON(paths));


    }

    public static TreeNode buildTestTreeNode() {

        TreeNode root = new TreeNode(1);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        TreeNode root2L = new TreeNode(4);
        TreeNode root2R = new TreeNode(5);
        TreeNode root3L = new TreeNode(6);
        TreeNode root4L = new TreeNode(7);

        root.setLeft(rootL);
        root.setRight(rootR);

        rootL.setLeft(root2L);
        rootL.setRight(root2R);
        root2L.setLeft(root3L);
        root3L.setLeft(root4L);

        return root;
    }

    /**
     * 方式1：循环深度优先遍历，筛出所有路径
     * @param treeNode
     * @return
     */
    public static List<String> findTreePaths(TreeNode treeNode) {
        if (null == treeNode) {
            return null;
        }

        List<TreeNode> leafNodes = new ArrayList<>();
        List<TreeNode> allNodes = new ArrayList<>();

        // 深度优先遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            allNodes.add(node);

            // 存储叶子节点
            if (null == node.getLeft() && null == node.getRight()) {
                leafNodes.add(node);
                continue;
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        // 遍历结果，筛出所有路径
        List<String> paths = new ArrayList<>();
        if (null == leafNodes || leafNodes.size() <= 0) {
            return paths;
        }
        for (TreeNode leafNode : leafNodes) {
            StringJoiner sj = new StringJoiner("->", "", "");
            for (TreeNode allNode : allNodes) {
                sj.add("" + allNode.getVal());

                if (allNode.getLeft() != null && allNode.getLeft() == leafNode) {
                    sj.add("" + leafNode.getVal());
                    break;
                }
                if (allNode.getRight() != null && allNode.getRight() == leafNode) {
                    sj.add("" + leafNode.getVal());
                    break;
                }

            }
            paths.add(sj.toString());
        }

        return paths;
    }

}
