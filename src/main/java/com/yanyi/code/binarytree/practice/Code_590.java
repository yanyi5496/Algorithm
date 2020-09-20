package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * @author chenqiang
 * @date 2020-09-18
 */
public class Code_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        function(root, res);
        return res;
    }

    public void function(Node root, List res) {
        if (root == null) {
            return ;
        }
        for (Node child : root.children) {
            function(root, res);
        }
        res.add(root.val);
    }
}
