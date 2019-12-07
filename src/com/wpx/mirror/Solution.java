package com.wpx.mirror;

/**
 *
 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {
    public void Mirror(TreeNode root) {
        // 如果当前值不为空，则交换左右子树的值
        TreeNode tmp = null;
        if(root!=null){
            tmp = root.left;
            root.left = root.right;
            root.right=tmp;
            if(root.left!=null)
                Mirror(root.left);
            if(root.right!=null)
                Mirror(root.right);
        }
    }
}

/*
Main()
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(8);
        TreeNode.printTree(root);
        s.Mirror(root);
        TreeNode.printTree(root);
 */
