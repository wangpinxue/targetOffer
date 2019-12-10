package com.wpx.findpathbytarget;

import java.util.ArrayList;

/**
 *
 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

 */
public class Solution {
    private ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // 判断root 是否为空
        if(root == null)
            return pathList;
        path.add(root.val);
        target -= root.val;
        // 如果为叶子节点，且和已经满足条件
        if(target == 0 && root.left ==null && root.right==null){
            pathList.add(new ArrayList<Integer>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 如果左右都遍历了，但是都不如何条件，那么就返回一层，继续遍历
        path.remove(path.size() - 1);
        return pathList;
    }
}

/*
main()
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(3);
        TreeNode.printTree(root);
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        pathList = s.FindPath(root, 4);
        System.out.println(pathList);
 */