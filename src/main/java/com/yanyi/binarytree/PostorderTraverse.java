package com.yanyi.binarytree;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author chenqiang
 * @description 后序遍历二叉树并还原
 */
public class PostorderTraverse {
    String NULL = "#";
    String SEP = ",";

    public static void main(String[] args) {
        String data = "1,2,#,4,#,#,3,#,#,";
        PreorderTraverse preorderTraverse = new PreorderTraverse();
        TreeNode treeNode = preorderTraverse.deSerialize(data);
        PostorderTraverse serialize = new PostorderTraverse();
        String s = serialize.serialize(treeNode);
        System.out.println("s = " + s);
        TreeNode node = serialize.deSeriilize(s);
        System.out.println("node = " + node);
    }

    /**
     * 序列化
     *
     * @param node
     * @return
     */
    String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        traverse(sb, node);
        return sb.toString();
    }

    /**
     * 后序遍历逻辑
     *
     * @param sb
     * @param node
     */
    void traverse(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        traverse(sb, node.left);
        traverse(sb, node.right);

        sb.append(node.val).append(SEP);
    }


    /**
     * 将后序遍历结果还原成二叉树
     *
     * @param data
     */
    TreeNode deSeriilize(String data) {
        String[] split = data.split(SEP);
        LinkedList<String> nodes = new LinkedList<>();
        Collections.addAll(nodes, split);
        return deTravserve(nodes);
    }


    TreeNode deTravserve(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        //最后的元素为二叉树根节点
        String last = nodes.removeLast();
        //根据根节点构造一棵树
        if (last.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        //从后往前在nodes中取元素，倒数第二个值为根节点的右孩子，先构造右节点
        root.right = deTravserve(nodes);
        root.left = deTravserve(nodes);
        return root;
    }


}
