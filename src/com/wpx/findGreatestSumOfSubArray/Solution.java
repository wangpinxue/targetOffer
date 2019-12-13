package com.wpx.findGreatestSumOfSubArray;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        int maxSum = array[0];
        int sum = array[0];
        for (int i = 0; i < length; i++) {
            if (maxSum < array[i])
                maxSum = array[i]; // 一个数也为最大和
            sum = array[i];
            if (array[i] > 0) {
                for (int j = i + 1; j < length; j++) {
                    sum += array[j];
                    if (sum > maxSum)
                        maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 使用动态规划的思想
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArrayDP(int[] array) {
        int sum = array[0], maxSum = array[0];
        int length = array.length;
        if(array == null || length == 0)
            return 0;
        int[] opt = new int[length]; // 存储到目前为止最大连续数组之和
        for (int i = 1; i < length; i++) {
            // 如果当前的序列的sum已经小于只取当前数的sum，那么就sum=当前数
            sum = max(sum+array[i], array[i]);
            maxSum = max(maxSum, sum);
        }

        return maxSum;
    }

    private int max(int a, int b){
        return a > b ? a:b;
    }
}

/*
main()
        Solution s = new Solution();
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(s.FindGreatestSumOfSubArray(arr));
 */
