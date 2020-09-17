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
        List<TreeNode> treeNodes = TreeDfs.foreachDfs(root);
        StringJoiner sj = new StringJoiner("->", "", "");
        for (TreeNode treeNode : treeNodes) {
            sj.add("" + treeNode.val);
        }
        System.out.println(sj.toString());
    }

    /**
     * 打印广度优先遍历
     * @param root
     */
    public static void printBfs(TreeNode root) {
        List<TreeNode> treeNodes = TreeBfs.bfsTraversal(root);
        StringJoiner sj = new StringJoiner("->", "", "");
        for (TreeNode treeNode : treeNodes) {
            sj.add("" + treeNode.val);
        }
        System.out.println(sj.toString());
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void printPreOrder(TreeNode root) {
        List<TreeNode> treeNodes = TreePreOrder.preOrderForeach(root);
        StringJoiner sj = new StringJoiner("->", "", "");
        for (TreeNode treeNode : treeNodes) {
            sj.add("" + treeNode.val);
        }
        System.out.println(sj.toString());
    }

    /**
     * 后序遍历打印
     * @param root
     */
    public static void printPostOrder(TreeNode root) {
        List<TreeNode> treeNodes = TreePostOrder.postOrderForeach(root);
        StringJoiner sj = new StringJoiner("->", "", "");
        for (TreeNode treeNode : treeNodes) {
            sj.add("" + treeNode.val);
        }
        System.out.println(sj.toString());
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void printInOrder(TreeNode root) {
        List<TreeNode> treeNodes = TreeInOrder.inOrderForeach(root);
        StringJoiner sj = new StringJoiner("->","","");
        for (TreeNode treeNode : treeNodes) {
            sj.add(""+treeNode.val);
        }
        System.out.println(sj.toString());
    }

}
