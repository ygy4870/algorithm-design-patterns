package com.ygy.study.algorithm.leetcode.tree;

import com.alibaba.fastjson.JSON;
import com.ygy.study.algorithm.tree.TreeNode;

import java.util.*;

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
public class TreeExercise0001 {

    public static void main(String[] args) {
//        TreeNode treeNode = TreeUtil.buildRandomTree(5, 100);
//        List<String> paths = findTreePaths(treeNode);
//        System.out.println(JSON.toJSON(paths));


        TreeNode treeNode = buildTestTreeNode();
        List<String> paths = findTreePaths(treeNode);
        System.out.println(JSON.toJSON(paths));

        List<String> paths2 = findTreePaths2(treeNode);
        System.out.println(JSON.toJSON(paths2));


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
     * @param root
     * @return
     */
    public static List<String> findTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (null == root) {
            return paths;
        }

        List<TreeNode> leafNodes = new ArrayList<>();
        List<TreeNode> allNodes = new ArrayList<>();

        // 深度优先遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            allNodes.add(node);

            // 存储叶子节点
            if (null == node.left && null == node.right) {
                leafNodes.add(node);
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 遍历结果，筛出所有路径
        if (null == leafNodes || leafNodes.size() <= 0) {
            return paths;
        }
        for (TreeNode leafNode : leafNodes) {
            StringJoiner sj = new StringJoiner("->", "", "");
            for (TreeNode allNode : allNodes) {
                sj.add("" + allNode.val);

                if (allNode.right != null && allNode.right == leafNode) {
                    sj.add("" + leafNode.val);
                    break;
                }
                if (allNode.right != null && allNode.right == leafNode) {
                    sj.add("" + leafNode.val);
                    break;
                }

            }
            paths.add(sj.toString());
        }

        return paths;
    }

    /**
     * 方式2：广度优先遍历（深度优先遍历也可以）
     * @param root
     * @return
     */
    public static List<String> findTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (null == root) {
            return paths;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer("" + root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathQueue.offer(path + "->" + node.right.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathQueue.offer(path + "->" + node.right.val);
            }
            if (node.right == null && node.right == null) {
                paths.add(path);
            }
        }

        return paths;
    }

}
