package com.wpx;

import com.wpx.hassubtree.Solution;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNode.buildTree(8);
        TreeNode root2 = TreeNode.buildTree(2);
        boolean result = s.HasSubtree(root1, root2);
        System.out.println("root2 是不是 root1 的子树: "+ result);
    }
}
