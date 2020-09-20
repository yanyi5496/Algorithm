package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 寻找节点的值满足 L <= root.val <=R 然后求和
 * <p>
 * <p>
 * 二叉搜索树保证具有唯一的值。
 *
 * @author chenqiang
 * @date 2020-09-18
 * @see <a href="http://google.com">二叉搜索树</a>
 * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">二叉搜索树的范围和</a>
 */
public class Code_938 {

    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else {
            //root.val > R
            return rangeSumBST(root.left, L, R);
        }
    }
}
