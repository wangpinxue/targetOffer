package com.wpx.verifySequenceOfBST;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int length = sequence.length;
        if(length==0)
            return false;
        return Verify(sequence,0,length-1);
    }

    public boolean Verify(int[] sequence, int left, int right){
        // 递推跳出条件，由于右子树可能为空，所以这个地方要用大于而非等于
        if(left>=right)
            return true;
        int root = sequence[right];
        //i 是左子树的遍历，j 是右子树的遍历
        int i =left,j=right-1;
        while(j>=i && sequence[j] > root){
            j--;
        }
        for(i = left;i <=j;i++){
            if(sequence[i] > root) {
                return false;
            }
        }
        return Verify(sequence, left,j) && Verify(sequence,j+1,right-1);
    }
}
/*
main()
        int[] sequence = {2,1};
        Solution s = new Solution();
        System.out.println(s.VerifySquenceOfBST(sequence));
 */