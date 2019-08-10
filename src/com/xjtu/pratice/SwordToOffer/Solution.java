package com.xjtu.pratice.SwordToOffer;

/*
 * 根据前序和和中序重建二叉树
 *
 * */
public class Solution {

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTrees(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTrees(int[] pre, int preStart, int preEnd,
                                           int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = inStart; i < inEnd; i++) {
            if (pre[preStart] == in[i]) {
                root.left = reConstructBinaryTrees(pre, preStart + 1, preStart + i - inStart,
                        in, inStart, i - 1);
                root.right = reConstructBinaryTrees(pre, i - inStart + preStart + 1, preEnd,
                        in, i + 1, inEnd);

            }
        }
        return root;
    }
}
