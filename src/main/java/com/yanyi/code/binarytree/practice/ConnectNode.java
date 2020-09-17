package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.PreorderTraverse;
import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;

/**
 * 把完全二叉树的每一层节点都用next指针连接起来
 * LeetCode-116
 *
 * @author chenqiang
 * @date 2020-09-16
 */
public class ConnectNode {
    public static void main(String[] args) {
        String data = "4,2,1,#,#,3,#,#,7,6,#,#,9,#,#";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        TreeNode connect = connect(treeNode);
        TreeOperation.show(connect);
    }

    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    public static void connectTwoNode(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }

        //将左节点的next指向右节点
        left.next = right;

        //连接相同父节点的两个子节点
        //将该节点的左孩子的next指向右孩子
        connectTwoNode(left.left, left.right);
        //将该节点的左孩子的next指向右孩子
        connectTwoNode(right.left, right.right);

        //连接跨越父节点的两个子节点
        //左节点的右孩子的next指向右节点的左孩子
        connectTwoNode(left.right, right.left);

    }
}
