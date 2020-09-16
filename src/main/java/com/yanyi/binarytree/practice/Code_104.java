package com.yanyi.binarytree.practice;

import com.yanyi.binarytree.PreorderTraverse;
import com.yanyi.binarytree.TreeNode;
import com.yanyi.binarytree.TreeOperation;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 给定二叉树 [3,9,#,#,20,15,#,#,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author chenqiang
 * @date 2020-09-16
 */
public class Code_104 {
    public static void main(String[] args) {
        String data = "3,9,#,#,20,15,#,#,7,5";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        int dfs = dfs(treeNode);
        System.out.println("dfs = " + dfs);
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //往下一层加一
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        //返回较大的值
        return left>right ? left : right;
    }
}
