package com.yanyi.binarytree;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author chenqiang
 * @description 二叉树前序遍历
 */
public class PreorderTraverse {

    String NULL = "#";
    String SEP = ",";


    public static void main(String[] args) {
        String data = "1,2,#,4,#,#,3,#,#,";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);

        String s = serialize.serialize(treeNode);
        System.out.println("s = " + s);
    }

    /**
     * 前序遍历
     *
     * @param node 父节点
     */
    public String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        traverse(node, sb);
        return sb.toString();
    }

    /**
     * 前序遍历执行方法
     *
     * @param node
     * @param sb
     */
    void traverse(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 输出根节点的值 前序遍历
        sb.append(node.val).append(SEP);
        //依次递归左孩子和右孩子
        traverse(node.left, sb);
        traverse(node.right, sb);
    }



    /**
     * 根据前序遍历结果还原成二叉树
     *
     * @param data
     * @return
     */
    public TreeNode deSerialize(String data) {
        LinkedList<String> nodes = new LinkedList();
        String[] split = data.split(SEP);
        Collections.addAll(nodes,split);
        return deTraverse(nodes);
    }

    /**
     * 前序递归还原二叉树
     * @param nodes
     * @return
     */
    TreeNode deTraverse(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        //列表的最左就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deTraverse(nodes);
        root.right = deTraverse(nodes);

        return root;
    }


}
