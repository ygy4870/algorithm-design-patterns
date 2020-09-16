package com.ygy.study.algorithm.tree;

import java.util.*;

public class TreeUtil {


    public static TreeNode buildRandomTree(int depth, int valBound) {
        if (depth <= 0) {
            return null;
        }
        Random random = new Random();

        TreeNode root = new TreeNode(random.nextInt(valBound));

        Queue<TreeNode> treeNodes = new LinkedList<>();
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

        printDfs(treeNode);
        printBfs(treeNode);
        printPreOrder(treeNode);
        printPostOrder(treeNode);
        printInOrder(treeNode);
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
    public static void printPreOrder(TreeNode root) {
        StringJoiner sj = new StringJoiner("->","","");
        preOrderRecursion(root, sj);
        System.out.println(sj.toString());
    }

    /**
     * 递归前序遍历，根->左->右
     * @param root
     * @param sj
     */
    public static void preOrderRecursion(TreeNode root, StringJoiner sj) {
        if (null == root) {
            return;
        }
        sj.add(""+root.val);
        preOrderRecursion(root.left, sj);
        preOrderRecursion(root.right, sj);
    }

    public static StringJoiner preOrderForeach(TreeNode root) {
        StringJoiner sj = new StringJoiner("->", "", "");
        if (null == root) {
            return sj;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sj.add("" + node.val);
            if (null != node.getRight()) {
                stack.push(node.getRight());
            }
            if (null != node.getLeft()) {
                stack.push(node.getLeft());
            }
        }
        return sj;
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void printPostOrder(TreeNode root) {
        StringJoiner sj = new StringJoiner("->","","");
        postOrderRecursion(root, sj);
        System.out.println(sj.toString());
    }

    /**
     * 递归后续遍历，左->右->根
     * @param root
     * @param sj
     */
    public static void postOrderRecursion(TreeNode root,StringJoiner sj) {
        if (null == root) {
            return;
        }
        postOrderRecursion(root.left, sj);
        postOrderRecursion(root.right, sj);
        sj.add(""+root.val);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void printInOrder(TreeNode root) {
        StringJoiner sj = new StringJoiner("->","","");
        inOrderRecursion(root, sj);
        System.out.println(sj.toString());
    }

    public static void inOrderRecursion(TreeNode root,StringJoiner sj) {
        if (null == root) {
            return;
        }
        inOrderRecursion(root.left, sj);
        sj.add(""+root.val);
        inOrderRecursion(root.right, sj);
    }

}
