package com.yanyi.code.test;

import com.yanyi.code.binarytree.Node;
import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树后续遍历
 * @author chenqiang
 * @date 2020-10-14 14:51
 */
public class Test_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        function(root, res);
        return res;
    }

    void function(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            function(child, res);
        }
        res.add(root.val);
    }
}
