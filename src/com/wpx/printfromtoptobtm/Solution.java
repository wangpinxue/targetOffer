package com.wpx.printfromtoptobtm;

import java.util.ArrayList;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        // 二叉树的层次遍历
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        ArrayList<Integer> print = new ArrayList<Integer>();
        TreeNode p = null;
        // 根节点入队
        if(root != null){
            queue.add(root);
        }else{
            return print;
        }
        while(!queue.isEmpty()){
            p = queue.get(0);
            print.add(p.val);
            queue.remove(0);
            if(p.left != null){
                queue.add(p.left);
            }
            if(p.right != null){
                queue.add(p.right);
            }
        }
        return print;
    }
}
