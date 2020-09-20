package com.yanyi.code.test;

import com.yanyi.code.binarytree.TreeNode;

/**
 * @author chenqiang
 * @date 2020-09-18
 */
public class Code_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 向下一层需要+1
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) +1;

        return left > right ? left : right;
    }
}
