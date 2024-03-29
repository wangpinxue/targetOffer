package com.wpx.stackFindMin;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution {
    // 定义全局变量min，在出栈和入栈的时候更新下min
    private int min;
    private int size;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        arr.add(node);
        //判断加入的node是否是最小的
        if (!minStack.isEmpty()) {
            min = minStack.peek();
            if (node < min)
                minStack.push(node);
            else
                minStack.push(min);
        } else {
            minStack.push(node);
        }
    }

    public void pop() {
        if (!minStack.isEmpty()) {
            min = minStack.peek();
            minStack.pop();
            arr.remove(arr.size() - 1);
        }
    }

    public int top() {
        return arr.get(arr.size() - 1);
    }

    public int min() {
        min = minStack.peek();
        return min;
    }
}

/*
main()
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
 */
