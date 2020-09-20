package com.ygy.study.algorithm.leetcode.tree;

import com.ygy.study.algorithm.tree.TreeNode;

import java.util.Stack;

/**
 * 路径总和
 *
 *      给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *      说明: 叶子节点是指没有子节点的节点。
 *      示例:
 *      给定如下二叉树，以及目标和 sum = 22，
 *                    5
 *                   / \
 *                  4   8
 *                 /   / \
 *                11  13  4
 *               /  \      \
 *              7    2      1
 *      返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class TreeExercise0002 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode root21 = new TreeNode(4);
        TreeNode root22 = new TreeNode(8);

        TreeNode root31 = new TreeNode(11);
        TreeNode root32 = new TreeNode(13);
        TreeNode root33 = new TreeNode(4);

        TreeNode root41 = new TreeNode(7);
        TreeNode root42 = new TreeNode(2);
        TreeNode root43 = new TreeNode(1);

        root.left = root21;
        root.right = root22;

        root21.left = root31;
        root22.left = root32;
        root22.right = root33;

        root31.left = root41;
        root31.right = root42;

        root33.right = root43;

        boolean success = hasPathSum(root, 23);
        System.out.println(success);

    }

    /**
     * 深度优先遍历
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (null==root) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<Integer> numStack = new Stack<>();
        numStack.push(root.val);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            Integer num = numStack.pop();
            if (treeNode.left==null && treeNode.right==null && num==sum) {
                return true;
            }
            if (null!=treeNode.right) {
                stack.push(treeNode.right);
                numStack.push(num+treeNode.right.val);
            }
            if (null!=treeNode.left) {
                stack.push(treeNode.left);
                numStack.push(num+treeNode.left.val);
            }
        }
        return false;
    }
}
