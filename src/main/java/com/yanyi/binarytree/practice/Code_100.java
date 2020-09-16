package com.yanyi.binarytree.practice;

import com.yanyi.binarytree.PreorderTraverse;
import com.yanyi.binarytree.TreeNode;
import com.yanyi.binarytree.TreeOperation;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author chenqiang
 * @date 2020-09-16
 */
public class Code_100 {
    public static void main(String[] args) {
        String data = "1,5,#,#,2,3";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode node1 = serialize.deSerialize(data);
        TreeOperation.show(node1);
        String data1 = "1,5,#,#,2,3,5";
        TreeNode node2 = serialize.deSerialize(data1);
        TreeOperation.show(node2);
        boolean sameTree = isSameTree(node1, node2);
        System.out.println("sameTree = " + sameTree);
    }

    /**
     * 递归比较每一个节点是否匹配
     * @param node1
     * @param node2
     * @return
     */
    private static boolean isSameTree(TreeNode node1, TreeNode node2) {
        //同时为null true
        if (node1 == null && node2 == null) {
            return true;
        }
        //只有一个为null false
        if (node1 == null) {
            return false;
        }
        if (node2 == null) {
            return false;
        }

        //如果父节点值相同，则比较左孩子和右孩子是否分别相同
        if (node1.val == node2.val) {
            return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
