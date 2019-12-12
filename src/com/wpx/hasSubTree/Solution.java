package com.wpx.hasSubTree;

/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesBisASubtree(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesBisASubtree(TreeNode root1, TreeNode root2) {
        //如果b遍历结束，则表示b是a的子树
        if (root2 == null) {
            return true;
        }
        //如果a都为空了，但是b不空，则不是
        if (root1 == null) {
            return false;
        }
        // 如果都不相等则返回false
        if (root1.val != root2.val) {
            return false;
        }
        // 相等再看左右子树
        return doesBisASubtree(root1.left, root2.left) && doesBisASubtree(root1.right, root2.right);
    }

}

    /*  Main()
        Solution s = new Solution();
        TreeNode root1 = TreeNode.buildTree(8);
        TreeNode root2 = TreeNode.buildTree(2);
        boolean result = s.HasSubtree(root1, root2);
        System.out.println("root2 是不是 root1 的子树: "+ result);
     */
