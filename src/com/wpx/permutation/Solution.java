package com.wpx.permutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        int length = str.length();
        if (str == null || length==0) {
            return list;
        }
        char[] arr = str.toCharArray();
        // 排序
        Arrays.sort(arr);
        list.add(String.valueOf(arr));
        int rIndex ; // 从右往左找最后一个大值
        int lIndex ; // 从左往右找第一个小值的索引
        while(true){
            // 更新lIndex的值
            lIndex = length-1;
            // 从左往右找第一个小值
            while (lIndex >= 1 && arr[lIndex - 1] >= arr[lIndex]) lIndex--;
            // 当找到最后一个序列的时候退出循环
            if(lIndex==0) break;
            rIndex = lIndex;
            //从右往左找最后一个大值
            while(rIndex<length && arr[lIndex-1] < arr[rIndex]) rIndex++;
            // 交换
            swap(arr, lIndex-1, rIndex-1);
            //将lIndex-1 后面的字母逆序
            reverse(arr,lIndex);
            list.add(String.valueOf(arr));
        }
        return list;
    }

    /**
     * 交换数组中的两个字母
     * @param arr
     * @param i
     * @param j
     */
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 从index开始，之后的数组翻转
     * @param arr
     * @param i
     */
    public void reverse(char[] arr, int i){
        if(i>arr.length-1 || arr.length ==0){
            return;
        }
        int length = arr.length;
        int mid = (length-i) /2;
        for(int j =0;j<mid;j++){
            int l = i+j;
            int r = length-1-j;
            if(l<=r)
                swap(arr,l,r);
        }
    }
}
