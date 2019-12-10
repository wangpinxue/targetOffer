package com.wpx.clonecomplivatednodelist;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        //1.不管random连接的对象，将节点复制在该节点之后
        if(pHead==null)
            return null;
        RandomListNode pNode = pHead; //指向头结点
        while(pNode!=null){
            RandomListNode cloneNode = new RandomListNode(pNode.label);
            cloneNode.next = pNode.next; //防止断链
            pNode.next = cloneNode;
            pNode = cloneNode.next; // 复制下一个节点
        }
        //2.遍历链表，处理random
        pNode = pHead;
        RandomListNode temp;
        while (pNode!=null && pNode.next!=null){
            if(pNode.random!=null) {
                pNode.next.random = pNode.random.next; //当前节点的下一个节点（即当前节点的复制节点）的random为该节点的random的复制节点

            }
            pNode = pNode.next.next;
        }
        //3.遍历链表，将链表拆分为原链表和处理后的链表
        RandomListNode pCloneHead = pHead.next;
        pNode = pHead;
        while(pNode.next!=null){
            temp = pNode.next;
            pNode.next = temp.next;
            pNode = temp;
        }
        return pCloneHead;
    }
}

/*
main()   [1,2,3,4,5]    1-->3,2-->5,4-->2
        Solution s = new Solution();
        RandomListNode root = new RandomListNode(1);
        RandomListNode pNode = root;
        RandomListNode pNode2=null;
        for(int i = 2; i <= 5 ;i++) {
            pNode.next = new RandomListNode(i);
            pNode = pNode.next;
        }
        pNode=root;
        pNode.random = pNode.next.next;
        while(pNode!=null) {
            if(pNode.label==2){
                pNode2=pNode;
                pNode.random = pNode.next.next.next;
            }else if(pNode.label==4)
                pNode.random =pNode2;
            pNode = pNode.next;
        }
        RandomListNode cloneRoot = s.Clone(root);
        RandomListNode cloneP = cloneRoot;
        while(cloneP!=null){
            System.out.println(cloneP.label);
            cloneP = cloneP.next;
        }
 */