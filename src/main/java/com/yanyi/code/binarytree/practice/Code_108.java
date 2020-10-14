package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author chenqiang
 * @date 2020-10-14 15:26
 */
public class Code_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? null : buildBinarySearchTree(nums, 0 , nums.length - 1);
    }

    TreeNode buildBinarySearchTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBinarySearchTree(nums, left , mid - 1);
        root.right = buildBinarySearchTree(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = new Code_108().sortedArrayToBST(nums);
        TreeOperation.show(treeNode);
    }
}
