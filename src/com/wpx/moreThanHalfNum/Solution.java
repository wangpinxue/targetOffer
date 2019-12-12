package com.wpx.moreThanHalfNum;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int max = array[0];
        int count = 0;
        int length =array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == max)
                count++;
            else {
                count--;
                if (count == 0) {
                    max = array[i];
                    count = 1;
                }
            }
        }
        //判断max的次数是否大于数组长度的一半
        count=0;
        for(int i =0;i<length;i++)
            if(array[i] == max)
                count ++;
        if(count>length/2)
            return max;
        return 0;
    }
}
/*
main()
        Solution s = new Solution();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(s.MoreThanHalfNum_Solution(arr));
 */