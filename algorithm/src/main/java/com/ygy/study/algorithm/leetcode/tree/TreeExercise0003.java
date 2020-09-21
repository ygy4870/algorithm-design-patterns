package com.ygy.study.algorithm.leetcode.tree;

import com.ygy.study.algorithm.tree.TreeBuilder;
import com.ygy.study.algorithm.tree.TreeNode;

import java.util.*;

/**
 * 二叉树中的最大路径和 难度-困难
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1：
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 */
public class TreeExercise0003 {

    public static void main(String[] args) {
        int[] preorder = {-10,9,20,15,7};
        int[] inorder = {9,-10,15,20,7};
        TreeNode treeNode = TreeBuilder.buildTree(preorder, inorder);
        System.out.println(maxPathSum(treeNode));
    }

    /**
     * 暴力法，遍历所有可能的树，每一棵树求和，取最大值----题意理解错了。。。。。。
     * @param root
     * @return
     */
    public static int maxPathSum(TreeNode root) {
        if (null==root) {
            return 0;
        }

        // 深度优先遍历所有node
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<TreeNode> treeNodes = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            treeNodes.add(node);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }

        // 遍历每一个节点树和，找出最大值
        int max = Integer.MIN_VALUE;
        for (TreeNode treeNode : treeNodes) {
//            int sum = treeSum(treeNode);
            int sum = treeSumCache(treeNode, new HashMap<>());
            if (sum>max) {
                max=sum;
            }
        }

        return max;
    }

    /**
     * 存在重复计算问题
     * @param root
     * @return
     */
    private static int treeSum(TreeNode root) {
        if (null==root) {
            return 0;
        }
        if (null==root.left&&null==root.right) {
            return root.val;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    /**
     * 缓存每一棵树的结点和，避免重复计算
     * @param root
     * @param sumCache
     * @return
     */
    private static int treeSumCache(TreeNode root, Map<TreeNode, Integer> sumCache) {
        if (null==root || null==sumCache) {
            return 0;
        }
        Integer sum = sumCache.get(root);
        if (null!=sum) {
            return sum;
        }
        if (null==root.left&&null==root.right) {
            return root.val;
        }
        int leftSum = treeSumCache(root.left, sumCache);
        int rightSum = treeSumCache(root.right, sumCache);
        int rootSum = root.val + leftSum + rightSum;

        sumCache.put(root.left, leftSum);
        sumCache.put(root.right, rightSum);
        sumCache.put(root, rootSum);

        return rootSum;
    }

}
