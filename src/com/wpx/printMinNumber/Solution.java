package com.wpx.printMinNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        String res = "";
        int length = numbers.length;
        for(int i =0;i < length;i++)
            list.add(numbers[i]);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                // o1 为3, o2 为32,   则 332 与 323 比较，输出1, 则 按小到大排列。3最后
                return str1.compareTo(str2);
            }
        });
        // 按顺序将list里的数字连起来
        for(int i:list){
            res+=i;
        }
        return res;
    }
}
