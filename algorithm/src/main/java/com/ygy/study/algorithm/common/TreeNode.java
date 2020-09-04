package com.ygy.study.algorithm.common;

import lombok.Data;

@Data
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}
