package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.TreeNode;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，
 * 使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * @author chenqiang
 * @date 2020-10-14 16:16
 */
public class Code_897 {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        return null;
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
    }

}
