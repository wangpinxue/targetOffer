package com.wpx;


import com.wpx.stackfindmin.Solution;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());
    }
}
