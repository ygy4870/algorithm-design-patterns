package com.ygy.study.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeBuilder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreePreIn(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 根据前序遍历、中序遍历构建树
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    private static TreeNode buildTreePreIn(int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (null==preorder || inorder==null) {
            return null;
        }
        if (preStart==preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];

        int i = inStart;
        boolean success = false;
        for (; i <= inEnd; i++) {
            if (rootVal==inorder[i]) {
                success = true;
                break;
            }
        }
        if (!success) {
            return null;
        }
        int count = i-inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreePreIn(preorder, preStart+1,preStart+count, inorder, inStart, inStart+count-1);
        root.right = buildTreePreIn(preorder, preStart+count+1,preEnd, inorder, inStart+count+1, inEnd);
        return root;
    }

    /**
     * 构建一颗随机树
     * @param depth
     * @param valBound
     * @return
     */
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

}
