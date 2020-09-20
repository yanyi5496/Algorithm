package com.yanyi.code.test;

import com.yanyi.code.binarytree.TreeNode;

/**
 * @author chenqiang
 * @date 2020-09-18
 */
public class Code_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //使用t1作为合并后的结果树
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
