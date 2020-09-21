package com.ygy.study.algorithm.leetcode.tree;

import com.ygy.study.algorithm.tree.TreeBuilder;
import com.ygy.study.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 二叉搜索树的最近公共祖先
 *
 *      给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *      百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *      例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *      示例 1:
 *      输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *      输出: 6
 *      解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 *      示例 2:
 *      输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *      输出: 2
 *      解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *      说明:
 *      所有节点的值都是唯一的。
 *      p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class TreeExercise0004 {

    public static void main(String[] args) {

        int[] preorder = {6,2,0,4,3,5,8,7,9};
        int[] inorder = {0,2,3,4,5,6,7,8,9};
        Map<String,TreeNode> cache = new HashMap<>();
        TreeNode treeNode = TreeBuilder.buildTree(preorder, inorder, cache);
//        TreeNode commonAncestor = lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(8));
        TreeNode commonAncestor = lowestCommonAncestor(treeNode, cache.get("2-1"), cache.get("4-3"));
        System.out.println(commonAncestor==null?"":commonAncestor.val);

        TreeNode commonAncestor3 = lowestCommonAncestor3(treeNode, cache.get("2-1"), cache.get("4-3"));
        System.out.println(commonAncestor3==null?"":commonAncestor3.val);
    }

    /**
     * 二叉搜索树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || q == null) {
            return null;
        }
        TreeNode current = root;
        while (null != current) {
            // 都在左边
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // 都在右边
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // 否则则为当前
            else {
                return current;
            }
        }
        return null;
    }

    /**
     * 非二叉搜索树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || q == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

        }
        return null;
    }

    /**
     * 非二叉搜索树,递归法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode commonAncestor = lowestCommonAncestor3(root.left, p, q);
        if (null != commonAncestor) {
            return commonAncestor;
        }
        commonAncestor = lowestCommonAncestor3(root.right, p, q);
        if (null != commonAncestor) {
            return commonAncestor;
        }
        return root;
    }

}
