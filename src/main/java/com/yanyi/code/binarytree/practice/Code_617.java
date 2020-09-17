package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.PreorderTraverse;
import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NUL的节点将直接作为新二叉树的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenqiang
 * @date 2020-09-16
 */
public class Code_617 {
    public static void main(String[] args) {
        String data = "1,5,#,#,2,3";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode node1 = serialize.deSerialize(data);
        TreeOperation.show(node1);
        String data1 = "1,5,#,#,2,3,5";
        TreeNode node2 = serialize.deSerialize(data1);
        TreeOperation.show(node2);
        TreeNode merge = merge(node1, node2);
        TreeOperation.show(merge);
    }

    private static TreeNode merge(TreeNode t1, TreeNode t2) {
        //不为NUL的节点将直接作为新二叉树的节点
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        //合并根节点 用t1作为结果树
        t1.val = t1.val + t2.val;

        //合并左右子节点
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);


        return t1;
    }
}
