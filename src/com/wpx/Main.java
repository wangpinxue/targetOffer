package com.wpx;

import com.wpx.permutation.Solution;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abca";
        ArrayList<String> list = new ArrayList<>();
        //list = s.Permutation(str);
        char[] chars = str.toCharArray();
        s.reverse(chars,2);
        System.out.println(chars);
    }
}
