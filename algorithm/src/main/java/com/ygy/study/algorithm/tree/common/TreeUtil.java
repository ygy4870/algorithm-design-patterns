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

        prinDfs(treeNode);
        prinBfs(treeNode);
    }

    /**
     * 打印深度优先遍历
     * @param root
     */
    public static void prinDfs(TreeNode root) {
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
    public static void prinBfs(TreeNode root) {
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

}
