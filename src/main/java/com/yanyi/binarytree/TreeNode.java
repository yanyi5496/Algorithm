package com.yanyi.binarytree;

/**
 * @author chenqiang
 * @description 树结构
 * @url https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}