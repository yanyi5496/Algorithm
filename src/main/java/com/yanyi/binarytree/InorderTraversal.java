package com.yanyi.binarytree;

/**
 * @author chenqiang
 * @description 中序遍历  无法确定根节点，无法进行反序列化
 */
public class InorderTraversal {
    String NULL = "#";
    String SEP = ",";

    public static void main(String[] args) {
        String data = "1,2,#,4,#,#,3,#,#,";
        PreorderTraverse preorderTraverse = new PreorderTraverse();
        TreeNode treeNode = preorderTraverse.deSerialize(data);
        InorderTraversal traversal = new InorderTraversal();
        String s = traversal.serialize(treeNode);
        System.out.println("s = " + s);
    }

    /**
     * 序列化
     *
     * @param node
     */
    String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        traverse(node, sb);
        return sb.toString();
    }

    /**
     * 中序遍历逻辑
     * @param node
     * @param sb
     */
    void traverse(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        traverse(node.left, sb);
        sb.append(node.val).append(SEP);
        traverse(node.right, sb);
    }
}
