package com.wpx.findpathbytarget;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode buildTree(int val) {
        TreeNode root = new TreeNode(val);
        TreeNode p = root;
        for (int i = val - 1; i > 0; i--) {
            p.left = new TreeNode(i);
            if (--i > 0) {
                p.right = new TreeNode(i);
            }
            p = p.right;
        }
        return root;
    }

    public static void printTree(TreeNode root){
        if(root!=null){
            printTree(root.left);
            System.out.print(" " + root.val);
            printTree(root.right);
        }
    }
}
