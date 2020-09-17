package com.yanyi.code.binarytree;

/**
 * @author chenqiang
 * @description 树结构
 * @url https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
