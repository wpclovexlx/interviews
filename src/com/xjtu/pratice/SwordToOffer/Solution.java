package com.xjtu.pratice.SwordToOffer;

/*
 * 根据前序和和中序重建二叉树
 *
 * */
public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(a, b);

    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd,
                                                  int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = inStart; i <= inEnd; i++)
            if (pre[preStart] == in[i]) {
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart,
                        in, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, i - inStart + preStart + 1, preEnd,
                        in, i + 1, inEnd);
                break;

            }
        return root;
    }
}
