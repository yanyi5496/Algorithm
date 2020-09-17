package com.yanyi.code.binarytree.practice;


import com.yanyi.code.binarytree.PreorderTraverse;
import com.yanyi.code.binarytree.TreeNode;
import com.yanyi.code.binarytree.TreeOperation;


/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 1、一颗树只有一个节点，它的深度是1；
 * <p>
 * 2、二叉树的根节点只有左子树而没有右子树，那么可以判断，二叉树的深度应该是其左子树的深度加1；
 * <p>
 * 3、二叉树的根节点只有右子树而没有左子树，那么可以判断，那么二叉树的深度应该是其右树的深度加1；
 * <p>
 * 4、二叉树的根节点既有右子树又有左子树，那么可以判断，那么二叉树的深度应该是其左右子树的深度较大值加1。
 * <p>
 * 一棵深度为k，且有2^k-1个节点的二叉树，称为满二叉树。这种树的特点是每一层上的节点数都是最大节点数。
 * 而在一棵二叉树中，除最后一层外，若其余层都是满的，并且最后一层或者是满的，或者是在右边缺少连续若干节点，则此二叉树为完全二叉树。
 * <p>
 * 具有n个节点的完全二叉树的深度为floor(log2n)+1。深度为k的完全二叉树，至少有2k-1个叶子节点，至多有2k-1个节点。
 * <p>
 * 给定二叉树 [3,9,#,#,20,15,#,#,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author chenqiang
 * @date 2020-09-16
 */
public class Code_104 {
    public static void main(String[] args) {
        String data = "3,9,#,#,20,15,#,#,7,5";
        PreorderTraverse serialize = new PreorderTraverse();
        TreeNode treeNode = serialize.deSerialize(data);
        TreeOperation.show(treeNode);
        int dfs = dfs(treeNode);
        System.out.println("dfs = " + dfs);
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //往下一层加一
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        //返回较大的值
        return left > right ? left : right;
    }
}
