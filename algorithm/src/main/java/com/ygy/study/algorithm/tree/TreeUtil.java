package com.ygy.study.algorithm.tree;

import java.util.List;
import java.util.StringJoiner;

public class TreeUtil {

    public static void main(String[] args) {
//        TreeNode treeNode = buildRandomTree(6, 100);
//
//        printDfs(treeNode);
//        printBfs(treeNode);
//        printPreOrder(treeNode);
//        printPostOrder(treeNode);
//        printInOrder(treeNode);

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode treeNode = TreeBuilder.buildTree(preorder, inorder);
        printPreOrder(treeNode);
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
