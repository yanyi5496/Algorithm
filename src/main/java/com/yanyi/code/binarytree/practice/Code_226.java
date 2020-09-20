package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.TreeNode;

/**
 * @author chenqiang
 * @date 2020-09-18
 */
public class Code_226 {

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
