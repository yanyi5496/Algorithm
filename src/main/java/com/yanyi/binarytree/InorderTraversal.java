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
     * @param root
     */
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    /**
     * 中序遍历逻辑
     * @param root
     * @param sb
     */
    void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        traverse(root.left, sb);
        sb.append(root.val).append(SEP);
        traverse(root.right, sb);
    }
}
