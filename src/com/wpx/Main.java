package com.wpx;


import com.wpx.printfromtoptobtm.Solution;
import com.wpx.printfromtoptobtm.TreeNode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(8);
        TreeNode.printTree(root);
        ArrayList<Integer> arr = s.PrintFromTopToBottom(root);
        System.out.println(arr);
    }
}
