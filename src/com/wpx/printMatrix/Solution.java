package com.wpx.printMatrix;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 && col == 0)
            return arr;
        int top = 0, left = 0, bottom = row - 1, right = col - 1;
        while (left <= right && top <= bottom) {
            //从左到右
            for (int i = left; i <= right; i++)
                arr.add(matrix[top][i]);
            //从上到下
            for (int i = top + 1; i <= bottom; i++)
                arr.add(matrix[i][right]);
            //从右到左,防止回文，只在top和bottom不是同一层是进行
            if(top != bottom)
                for (int i = right - 1; i >= left; i--) {
                    arr.add(matrix[bottom][i]);
                }
            //从下到上,防止一列时出问题
            if(left != right)
                for (int i = bottom - 1; i > top; i--) {
                    arr.add(matrix[i][left]);
                }
            left++;
            top++;
            right--;
            bottom--;
        }
        return arr;
    }
}

/*
main()
        ArrayList<Integer> arr = null;
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution s = new Solution();
        arr = s.printMatrix(matrix);
        System.out.println(arr);
 */
