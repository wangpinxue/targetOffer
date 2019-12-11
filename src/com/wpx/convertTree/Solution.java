package com.wpx.convertTree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {
    private boolean isRoot = true;

    public TreeNode Convert(TreeNode pRootOfTree) {
        return ConvertNotRecuision(pRootOfTree);
    }

    /**
     * 非递归 ，利用栈
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode ConvertNotRecuision(TreeNode pRootOfTree) {
        TreeNode linkedRoot = null, p = pRootOfTree;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (pRootOfTree == null)
            return null;
        // 当p存在或栈非空的时候执行
        while (p != null || !stack.isEmpty()) {
            // 中序遍历，找到最左节点，为最小值
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop(); // 中序遍历
            // 如果是根节点，那么pre要特殊处理
            if (isRoot) {
                linkedRoot = p;
                pre = linkedRoot;
                isRoot = false;   // 这里的pre.right 不用指向p
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return linkedRoot;
    }

    /**
     * 递归方法
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode ConvertRecuision(TreeNode pRootOfTree, TreeNode pre) {
        return null;
    }
}
