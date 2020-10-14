package com.yanyi.code.binarytree.practice;

import com.yanyi.code.binarytree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找重复子树
 *
 * @author chenqiang
 * @date 2020-10-14 10:52
 */
public class Code_652 {
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travers(root);
        return res;
    }

    String travers(TreeNode root) {
        if (root == null) {
            return "#";
        }
        //按后续对子树递归遍历
        String left = travers(root.left);
        String right = travers(root.right);

        String subString = left + "," + right + "," + root.val;

        Integer freq = memo.getOrDefault(subString, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subString, freq + 1);
        return subString;
    }

    public static void main(String[] args) {

    }
}
