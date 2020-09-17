package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.PreorderTraverse;
import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序遍历。
 * 直接认为树已经成功构建
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * @author chenqiang
 * @date 2020-09-16
 */
public class Code_94 {
    public static void main(String[] args) {
        String data = "3,9,#,#,20,15,#,#,7";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        List<Integer> reverse = reverse(treeNode);
        System.out.println("reverse = " + reverse);
    }

    private static List<Integer> reverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        prorder(node, res);
        return res;
    }

    //中序遍历
    private static void prorder(TreeNode node, List res) {
        if (node == null) {
            return;
        }

        prorder(node.left, res);

        res.add(node.val);

        prorder(node.right, res);
    }



}
