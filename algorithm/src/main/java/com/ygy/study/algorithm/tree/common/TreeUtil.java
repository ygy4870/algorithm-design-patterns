package com.ygy.study.algorithm.tree.common;

import java.util.*;

public class TreeUtil {


    public static TreeNode buildRandomTree(int depth, int valBound) {
        if (depth <= 0) {
            return null;
        }
        Random random = new Random();

        TreeNode root = new TreeNode(random.nextInt(valBound));

        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
        treeNodes.offer(root);

        TreeNode temp = null;
        for (int i = 0; i < depth * 2 && !treeNodes.isEmpty(); i++) {

            temp = treeNodes.poll();

            if (randTrue(random)) {
                TreeNode treeNode = new TreeNode(random.nextInt(valBound));
                temp.setLeft(treeNode);
                treeNodes.offer(treeNode);
            }
            if (randTrue(random)) {
                TreeNode treeNode = new TreeNode(random.nextInt(valBound));
                temp.setRight(treeNode);
                treeNodes.offer(treeNode);
            }

        }


        return root;
    }

    private static boolean randTrue(Random random) {
        return random.nextInt(10) < 5 ? true : false;
    }


    public static void main(String[] args) {
        TreeNode treeNode = buildRandomTree(6, 100);
        System.out.println(treeNode);

        printDfs(treeNode);
        printBfs(treeNode);
        printPrefs(treeNode);
        printPostfs(treeNode);
        printMiddlefs(treeNode);
    }

    /**
     * 打印深度优先遍历
     * @param root
     */
    public static void printDfs(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringJoiner sj = new StringJoiner("->", "", "");
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sj.add("" + node.val);

            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        System.out.println(sj.toString());
    }

    /**
     * 打印广度优先遍历
     * @param root
     */
    public static void printBfs(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringJoiner sj = new StringJoiner("->", "", "");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sj.add("" + node.val);

            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        System.out.println(sj.toString());
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void printPrefs(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val+"->");
        printPrefs(root.left);
        printPrefs(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void printPostfs(TreeNode root) {
        if (null == root) {
            return;
        }
        printPostfs(root.left);
        printPostfs(root.right);
        System.out.print(root.val+"->");
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void printMiddlefs(TreeNode root) {
        if (null == root) {
            return;
        }
        printMiddlefs(root.left);
        System.out.print(root.val+"->");
        printMiddlefs(root.right);
    }

}
