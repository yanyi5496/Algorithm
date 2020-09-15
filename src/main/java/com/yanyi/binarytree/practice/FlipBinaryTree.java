package com.yanyi.binarytree.practice;

import com.yanyi.binarytree.PreorderTraverse;
import com.yanyi.binarytree.TreeNode;
import com.yanyi.binarytree.TreeOperation;

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
     *
     * @param node
     * @return
     */
    public static TreeNode flip(TreeNode node) {
        if (node == null) {
            return null;
        }
        //交换左右节点值
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        //左右节点的子节点继续翻转
        flip(node.left);
        flip(node.right);
        return node;
    }
}
