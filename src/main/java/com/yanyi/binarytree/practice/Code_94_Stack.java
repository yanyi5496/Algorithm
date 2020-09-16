package com.yanyi.binarytree.practice;

import com.yanyi.binarytree.PreorderTraverse;
import com.yanyi.binarytree.TreeNode;
import com.yanyi.binarytree.TreeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94题 通过Stack实现
 *
 * 给定一个二叉树，返回它的中序遍历。
 *   直接认为树已经成功构建
 *   输入: [1,5,#,#,2,3]
 *      1
 *    /  \
 *   5    2
 *       /
 *      3
 *
 * @author chenqiang
 * @date 2020-09-16
 */
public class Code_94_Stack {
    public static void main(String[] args) {
        String data = "1,5,#,#,2,3";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        List<Integer> reverse = reverse(treeNode);
        System.out.println("reverse = " + reverse);
    }

    private static List<Integer> reverse(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = node;

        //当前node不为空 或 栈不为空
        while (cur != null || !stack.isEmpty()) {
            //node不为空放入栈中 继续往左节点移动放入栈中
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
