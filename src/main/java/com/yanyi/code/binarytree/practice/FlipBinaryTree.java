package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.PreorderTraverse;
import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;

/**
 * 翻转二叉树 原二叉树如下
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 将该二叉树翻转成如下
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * LeetCode-226
 * 解题思路：二叉树上的每个节点的左右子节点进行交换，最后就能翻转成功
 * @author chenqiang
 * @date 2020-09-15
 */
public class FlipBinaryTree {
    public static void main(String[] args) {
        String data = "4,2,1,#,#,3,#,#,7,6,#,#,9,#,#";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);

        TreeNode flip = flip(treeNode);
        TreeOperation.show(flip);
    }

    /**
     * 翻转方法
     * @param root
     * @return
     */
    public static TreeNode flip(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换左右节点值
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //左右节点的子节点继续翻转
        flip(root.left);
        flip(root.right);
        return root;
    }
}
