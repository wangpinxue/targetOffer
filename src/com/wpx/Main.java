package com.wpx;


import com.wpx.printMinNumber.Solution;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums= {3,32,321};
        System.out.println(s.PrintMinNumber(nums));
        int o1 = 3, o2 = 32;
        String str1 = o1 + "" + o2;
        String str2 = o2 + "" + o1;
        System.out.println(str1.compareTo(str2));
    }
}
