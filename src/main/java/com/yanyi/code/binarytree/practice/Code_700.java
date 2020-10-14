package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.PreorderTraverse;
import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * @author chenqiang
 * @date 2020-10-14 14:58
 */
public class Code_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return function(root, val);
    }

    TreeNode function(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        } else if (val < root.val) {
            return function(root.left, val);
        } else {
            return function(root.right, val);
        }
    }

    public static void main(String[] args) {
        String data = "4,2,1,#,#,3,#,#,7";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        TreeNode x = new Code_700().searchBST(treeNode, 2);
        TreeOperation.show(x);
    }
}
