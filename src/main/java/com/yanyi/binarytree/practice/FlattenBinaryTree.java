package com.yanyi.binarytree.practice;

import com.yanyi.binarytree.PreorderTraverse;
import com.yanyi.binarytree.TreeNode;
import com.yanyi.binarytree.TreeOperation;

/**
 * 二叉树展开为链表
 * LeetCode-114
 * @author chenqiang
 * @date 2020-09-16
 */
public class FlattenBinaryTree {
    public static void main(String[] args) {
        String data = "4,2,1,#,#,3,#,#,7,6,#,#,9,#,#";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        flatten(treeNode);
        TreeOperation.show(treeNode);

    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        //后续遍历位置
        flatten(root.left);
        flatten(root.right);


        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树作为右子树
        root.right = left;
        root.left = null;

        //将原先的右子树接到当前右子树的末端
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;



    }
}
