package com.yanyi.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenqiang
 * @description 二叉树的层级遍历
 */
public class LevelorderTraversal {
    public static void main(String[] args) {
        String data = "1,2,#,4,#,#,3,#,#,";
        PreorderTraverse preorderTraverse = new PreorderTraverse();
        TreeNode treeNode = preorderTraverse.deSerialize(data);
        traverse(treeNode);
    }

    /**
     * 层级遍历 从根节点开始，按左右子树顺序放入队列中，然后逐层遍历。
     * @param root
     */
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println("current.val = " + current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

    }
}
